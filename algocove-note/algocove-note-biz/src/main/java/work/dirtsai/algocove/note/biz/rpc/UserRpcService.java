package work.dirtsai.algocove.note.biz.rpc;

import cn.hutool.core.collection.CollUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.user.api.UserFeignApi;
import work.dirtsai.algocove.user.dto.req.FindUserByIdReqDTO;
import work.dirtsai.algocove.user.dto.req.FindUsersByIdsReqDTO;
import work.dirtsai.algocove.user.dto.resp.FindUserByIdRespDTO;
import work.dirtsai.algocove.user.dto.resp.FindUserByIdRspDTO;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserRpcService {

    @Resource
    private UserFeignApi userFeignApi;

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    public FindUserByIdRespDTO findById(Long userId) {
        FindUserByIdReqDTO findUserByIdReqDTO = new FindUserByIdReqDTO();
        findUserByIdReqDTO.setId(userId);

        Response<FindUserByIdRespDTO> response = userFeignApi.findById(findUserByIdReqDTO);

        if (Objects.isNull(response) || !response.isSuccess()) {
            return null;
        }

        return response.getData();
    }

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
