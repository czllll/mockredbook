package work.dirtsai.mockredbook.auth.rpc;

import jakarta.annotation.Resource;
import work.dirtsai.framework.common.response.Response;
import org.springframework.stereotype.Component;
import work.dirtsai.mockredbook.user.api.UserFeignApi;
import work.dirtsai.mockredbook.user.dto.req.FindUserByPhoneReqDTO;
import work.dirtsai.mockredbook.user.dto.req.RegisterUserReqDTO;
import work.dirtsai.mockredbook.user.dto.req.UpdateUserPasswordReqDTO;
import work.dirtsai.mockredbook.user.dto.resp.FindUserByPhoneRspDTO;

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

    /**
     * 根据手机号查询用户信息
     *
     * @param phone
     * @return
     */
    public FindUserByPhoneRspDTO findUserByPhone(String phone) {
        FindUserByPhoneReqDTO findUserByPhoneReqDTO = new FindUserByPhoneReqDTO();
        findUserByPhoneReqDTO.setPhone(phone);

        Response<FindUserByPhoneRspDTO> response = userFeignApi.findByPhone(findUserByPhoneReqDTO);

        if (!response.isSuccess()) {
            return null;
        }

        return response.getData();
    }

    /**
     * 密码更新
     *
     * @param encodePassword
     */
    public void updatePassword(String encodePassword) {
        UpdateUserPasswordReqDTO updateUserPasswordReqDTO = new UpdateUserPasswordReqDTO();
        updateUserPasswordReqDTO.setEncodePassword(encodePassword);

        userFeignApi.updatePassword(updateUserPasswordReqDTO);
    }

}