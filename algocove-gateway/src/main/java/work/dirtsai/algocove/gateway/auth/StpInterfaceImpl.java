package work.dirtsai.algocove.gateway.auth;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.collection.CollUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import work.dirtsai.algocove.gateway.constant.RedisKeyConstants;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j

public class StpInterfaceImpl implements StpInterface {

    @Resource
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private ObjectMapper objectMapper;


    /**
     * 获取用户权限
     *
     * @param loginId
     * @param loginType
     * @return
     */
    @SneakyThrows
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        log.info("## 开始获取用户权限列表, loginId: {}, loginType: {}", loginId, loginType);

        // 构建 用户-角色 Redis Key
        String userRolesKey = RedisKeyConstants.buildUserRoleKey(Long.parseLong(loginId.toString()));
        log.info("## 构建的用户角色 Redis Key: {}", userRolesKey);

        // 根据用户 ID ，从 Redis 中获取该用户的角色集合
        String useRolesValue = redisTemplate.opsForValue().get(userRolesKey);
        log.info("## 从 Redis 获取到的角色 JSON 字符串: {}", useRolesValue);

        if (StringUtils.isBlank(useRolesValue)) {
            log.warn("## 用户角色数据为空，返回 null");
            return null;
        }

        // 将 JSON 字符串转换为 List<String> 角色集合
        List<String> userRoleKeys;
        try {
            userRoleKeys = objectMapper.readValue(useRolesValue, new TypeReference<>() {});
            log.info("## 解析出的用户角色列表: {}", userRoleKeys);
        } catch (JsonProcessingException e) {
            log.error("## 解析用户角色 JSON 失败, loginId: {}, JSON: {}", loginId, useRolesValue, e);
            return null;
        }

        if (CollUtil.isEmpty(userRoleKeys)) {
            log.warn("## 解析出的用户角色列表为空，返回 null");
            return null;
        }

        // 查询这些角色对应的权限
        List<String> rolePermissionsKeys = userRoleKeys.stream()
                .map(RedisKeyConstants::buildRolePermissionsKey)
                .collect(Collectors.toList());

        log.info("## 构建的角色权限 Redis Key 列表: {}", rolePermissionsKeys);

        // 通过 key 集合批量查询权限，提升查询性能。
        List<String> rolePermissionsValues = redisTemplate.opsForValue().multiGet(rolePermissionsKeys);
        log.info("## 从 Redis 获取到的角色权限 JSON 列表: {}", rolePermissionsValues);

        if (CollUtil.isEmpty(rolePermissionsValues)) {
            log.warn("## 角色权限数据为空，返回 null");
            return null;
        }

        List<String> permissions = CollUtil.newArrayList();

        // 遍历所有角色的权限集合，统一添加到 permissions 集合中
        rolePermissionsValues.forEach(jsonValue -> {
            if (StringUtils.isNotBlank(jsonValue)) {
                try {
                    List<String> rolePermissions = objectMapper.readValue(jsonValue, new TypeReference<>() {});
                    permissions.addAll(rolePermissions);
                    log.info("## 解析出的权限集合: {}", rolePermissions);
                } catch (JsonProcessingException e) {
                    log.error("## 解析角色权限 JSON 失败, JSON: {}", jsonValue, e);
                }
            } else {
                log.warn("## 角色权限 JSON 字符串为空，跳过该角色");
            }
        });

        log.info("## 用户最终的权限列表: {}", permissions);
        return permissions;
    }


    /**
     * 获取用户角色
     *
     * @param loginId
     * @param loginType
     * @return
     */
    @SneakyThrows
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        log.info("## 获取用户角色列表, loginId: {}", loginId);

        // 构建 用户-角色 Redis Key
        String userRolesKey = RedisKeyConstants.buildUserRoleKey(Long.valueOf(loginId.toString()));

        // 根据用户 ID ，从 Redis 中获取该用户的角色集合
        String useRolesValue = redisTemplate.opsForValue().get(userRolesKey);

        if (StringUtils.isBlank(useRolesValue)) {
            return null;
        }

        // 将 JSON 字符串转换为 List<String> 集合
        return objectMapper.readValue(useRolesValue, new TypeReference<>() {});
    }

}