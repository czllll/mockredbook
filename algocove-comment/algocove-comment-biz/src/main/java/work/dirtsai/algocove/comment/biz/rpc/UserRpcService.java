package work.dirtsai.algocove.comment.biz.rpc;

import cn.hutool.core.collection.CollUtil;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.user.api.UserFeignApi;
import work.dirtsai.algocove.user.dto.req.FindUsersByIdsReqDTO;
import work.dirtsai.algocove.user.dto.resp.FindUserByIdRspDTO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: czl
 * @date: 2024/4/13 23:29
 * @version: v1.0.0
 * @description: 用户服务
 **/
@Component
public class UserRpcService {

    @Resource
    private UserFeignApi userFeignApi;

    /**
     * 批量查询用户信息
     *
     * @param userIds
     * @return
     */
    public List<FindUserByIdRspDTO> findByIds(List<Long> userIds) {
        if (CollUtil.isEmpty(userIds)) {
            return null;
        }

        FindUsersByIdsReqDTO findUsersByIdsReqDTO = new FindUsersByIdsReqDTO();
        // 去重, 并设置用户 ID 集合
        findUsersByIdsReqDTO.setIds(userIds.stream().distinct().collect(Collectors.toList()));

        Response<List<FindUserByIdRspDTO>> response = userFeignApi.findByIds(findUsersByIdsReqDTO);

        if (!response.isSuccess() || Objects.isNull(response.getData()) || CollUtil.isEmpty(response.getData())) {
            return null;
        }

        return response.getData();
    }

}
