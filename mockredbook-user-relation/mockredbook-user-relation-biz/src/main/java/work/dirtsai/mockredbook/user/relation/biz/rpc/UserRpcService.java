package work.dirtsai.mockredbook.user.relation.biz.rpc;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.user.api.UserFeignApi;
import work.dirtsai.mockredbook.user.dto.req.FindUserByIdReqDTO;
import work.dirtsai.mockredbook.user.dto.resp.FindUserByIdRespDTO;

import java.util.Objects;

@Component
public class UserRpcService {

    @Resource
    private UserFeignApi userFeignApi;

    /**
     * 根据用户 ID 查询
     *
     * @param userId
     * @return
     */
    public FindUserByIdRespDTO findById(Long userId) {
        FindUserByIdReqDTO findUserByIdReqDTO = new FindUserByIdReqDTO();
        findUserByIdReqDTO.setId(userId);

        Response<FindUserByIdRespDTO> response = userFeignApi.findById(findUserByIdReqDTO);

        if (!response.isSuccess() || Objects.isNull(response.getData())) {
            return null;
        }

        return response.getData();
    }


}

