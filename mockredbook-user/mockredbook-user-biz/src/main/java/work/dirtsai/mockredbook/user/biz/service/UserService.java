package work.dirtsai.mockredbook.user.biz.service;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.user.biz.model.vo.UpdateUserInfoReqVO;
import work.dirtsai.mockredbook.user.dto.req.RegisterUserReqDTO;

public interface UserService {

    /**
     * 更新用户信息
     *
     * @param updateUserInfoReqVO
     * @return
     */
    Response<?> updateUserInfo(UpdateUserInfoReqVO updateUserInfoReqVO);

    /**
     * 用户注册
     *
     * @param registerUserReqDTO
     * @return
     */
    Response<Long> register(RegisterUserReqDTO registerUserReqDTO);
}
