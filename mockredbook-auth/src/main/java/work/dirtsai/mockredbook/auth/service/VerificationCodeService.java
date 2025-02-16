package work.dirtsai.mockredbook.auth.service;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.auth.model.vo.verificationcode.SendVerificationCodeReqVO;

public interface VerificationCodeService {

    Response<?> send(SendVerificationCodeReqVO sendVerificationCodeReqVO);
}
