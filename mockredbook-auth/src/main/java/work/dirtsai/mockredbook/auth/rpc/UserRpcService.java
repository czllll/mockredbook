package work.dirtsai.mockredbook.auth.rpc;

import jakarta.annotation.Resource;
import work.dirtsai.framework.common.response.Response;
import org.springframework.stereotype.Component;
import work.dirtsai.mockredbook.user.api.UserFeignApi;
import work.dirtsai.mockredbook.user.dto.req.RegisterUserReqDTO;
/**
 * 用户服务
 */
@Component
public class UserRpcService {

    @Resource
    private UserFeignApi userFeignApi;

    /**
     * 用户注册
     *
     * @param phone
     * @return
     */
    public Long registerUser(String phone) {
        RegisterUserReqDTO registerUserReqDTO = new RegisterUserReqDTO();
        registerUserReqDTO.setPhone(phone);

        Response<Long> response = userFeignApi.registerUser(registerUserReqDTO);

        if (!response.isSuccess()) {
            return null;
        }

        return response.getData();
    }

}