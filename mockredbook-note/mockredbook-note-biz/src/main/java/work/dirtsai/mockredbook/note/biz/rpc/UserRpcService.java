package work.dirtsai.mockredbook.note.biz.rpc;

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

}
