package work.dirtsai.algocove.user.biz.rpc;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.count.api.CountFeignApi;
import work.dirtsai.algocove.count.dto.FindUserCountByIdReqDTO;
import work.dirtsai.algocove.count.dto.FindUserCountByIdRspDTO;

import java.util.Objects;

/**
 * @author czl$
 * @date 2025/4/21$
 */


@Component
public class CountRpcService {

    @Resource
    private CountFeignApi countFeignApi;

    /**
     * 查询用户计数信息
     * @param userId
     * @return
     */
    public FindUserCountByIdRspDTO findUserCountById(Long userId) {
        FindUserCountByIdReqDTO findUserCountByIdReqDTO = new FindUserCountByIdReqDTO();
        findUserCountByIdReqDTO.setUserId(userId);

        Response<FindUserCountByIdRspDTO> response = countFeignApi.findUserCount(findUserCountByIdReqDTO);

        if (Objects.isNull(response) || !response.isSuccess()) {
            return null;
        }

        return response.getData();
    }

}