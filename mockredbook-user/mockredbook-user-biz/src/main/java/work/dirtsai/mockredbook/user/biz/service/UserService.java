package work.dirtsai.mockredbook.user.biz.service;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.user.biz.model.vo.UpdateUserInfoReqVO;

public interface UserService {

    /**
     * 更新用户信息
     *
     * @param updateUserInfoReqVO
     * @return
     */
    Response<?> updateUserInfo(UpdateUserInfoReqVO updateUserInfoReqVO);
}
