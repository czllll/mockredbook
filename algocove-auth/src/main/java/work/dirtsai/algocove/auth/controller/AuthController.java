package work.dirtsai.algocove.auth.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import work.dirtsai.framework.biz.operationlog.aspect.ApiOperationLog;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.auth.model.vo.user.UpdatePasswordReqVO;
import work.dirtsai.algocove.auth.model.vo.user.UserLoginReqVO;
import work.dirtsai.algocove.auth.service.AuthService;

@RestController
@Slf4j
public class AuthController {


    @Resource
    private AuthService userService;

    @PostMapping("/login")
    @ApiOperationLog(description = "用户登录/注册")
    public Response<String> loginAndRegister(@Validated @RequestBody UserLoginReqVO userLoginReqVO) {
        return userService.loginAndRegister(userLoginReqVO);
    }

    @PostMapping("/logout")
    @ApiOperationLog(description = "账号登出")
    public Response<?> logout() {
        return userService.logout();
    }

    @PostMapping("/password/update")
    @ApiOperationLog(description = "修改密码")
    public Response<?> updatePassword(@Validated @RequestBody UpdatePasswordReqVO updatePasswordReqVO) {
        return userService.updatePassword(updatePasswordReqVO);
    }

}
