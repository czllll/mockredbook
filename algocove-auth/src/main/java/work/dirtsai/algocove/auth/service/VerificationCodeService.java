package work.dirtsai.algocove.auth.service;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.auth.model.vo.verificationcode.SendVerificationCodeReqVO;

public interface VerificationCodeService {

    Response<String> send(SendVerificationCodeReqVO sendVerificationCodeReqVO);
}
