package work.dirtsai.mockredbook.auth.service;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.auth.model.vo.user.UserLoginReqVO;

public interface UserService {

    /**
     * 登录与注册
     * @param userLoginReqVO
     * @return
     */
    Response<String> loginAndRegister(UserLoginReqVO userLoginReqVO);

    /**
     * 退出登录
     * @return
     */
    Response<?> logout();
}