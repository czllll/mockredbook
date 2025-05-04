package work.dirtsai.algocove.auth.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import work.dirtsai.framework.biz.operationlog.aspect.ApiOperationLog;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.auth.model.vo.verificationcode.SendVerificationCodeReqVO;
import work.dirtsai.algocove.auth.service.VerificationCodeService;

@RestController
@Slf4j
public class VerificationCodeController {

    @Resource
    private VerificationCodeService verificationCodeService;

    @PostMapping("/verification/code/send")
    @ApiOperationLog(description = "发送短信验证码")
    public Response<String> send (@Validated @RequestBody SendVerificationCodeReqVO sendVerificationCodeReqVO) {
        return verificationCodeService.send(sendVerificationCodeReqVO);
    }
}
