package work.dirtsai.mockredbook.auth.service.impl;

import cn.hutool.core.util.RandomUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import work.dirtsai.framework.common.exception.BizException;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.auth.constant.RedisKeyConstants;
import work.dirtsai.mockredbook.auth.enums.ResponseCodeEnum;
import work.dirtsai.mockredbook.auth.model.vo.verificationcode.SendVerificationCodeReqVO;
import work.dirtsai.mockredbook.auth.service.VerificationCodeService;
import work.dirtsai.mockredbook.auth.sms.AliyunSmsHelper;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class VerificationCodeServiceImpl implements VerificationCodeService {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Resource(name = "taskExecutor")
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Resource
    private AliyunSmsHelper aliyunSmsHelper;

    @Override
    public Response<String> send(SendVerificationCodeReqVO sendVerificationCodeReqVO) {
        String phoneNumber = sendVerificationCodeReqVO.getPhone();

        // 构建验证码 redis key
        String key = RedisKeyConstants.buildVerificationCodeKey(phoneNumber);

        boolean isSent = redisTemplate.hasKey(key);
        if (isSent) {
            throw new BizException(ResponseCodeEnum.VERIFICATION_CODE_SEND_FREQUENTLY);
        }

        String verificationCode = RandomUtil.randomNumbers(6);


        // 调用第三方短信发送服务
        threadPoolTaskExecutor.submit(() -> {
            String signName = "阿里云短信测试";
            String templateCode = "SMS_154950909";
            String templateParam = String.format("{\"code\":\"%s\"}", verificationCode);
            aliyunSmsHelper.sendMessage(signName, templateCode, phoneNumber, templateParam);
        });

        log.info("==> 手机号: {}, 已发送验证码：【{}】", phoneNumber, verificationCode);
        // 发送后存到redis，三分钟过期
        redisTemplate.opsForValue().set(key, verificationCode, 3, TimeUnit.MINUTES);

        return Response.success(verificationCode);

    }
}
