package work.dirtsai.mockredbook.user.biz.service;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.user.biz.model.vo.UpdateUserInfoReqVO;
import work.dirtsai.mockredbook.user.dto.req.FindUserByPhoneReqDTO;
import work.dirtsai.mockredbook.user.dto.req.RegisterUserReqDTO;
import work.dirtsai.mockredbook.user.dto.resp.FindUserByPhoneRspDTO;

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

    /**
     * 根据手机号查询用户信息
     *
     * @param findUserByPhoneReqDTO
     * @return
     */
    Response<FindUserByPhoneRspDTO> findByPhone(FindUserByPhoneReqDTO findUserByPhoneReqDTO);
}
