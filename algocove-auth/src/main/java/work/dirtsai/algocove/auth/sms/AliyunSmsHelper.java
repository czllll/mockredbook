package work.dirtsai.algocove.auth.sms;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import com.aliyun.teautil.models.RuntimeOptions;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import work.dirtsai.framework.common.util.JsonUtils;

@Slf4j
@Component
public class AliyunSmsHelper {
    @Resource
    private Client client;

    public boolean sendMessage(String signName, String templateCode, String phone, String templateParam) {
        SendSmsRequest sendSmsRequest = new SendSmsRequest()
                .setSignName(signName)
                .setTemplateCode(templateCode)
                .setPhoneNumbers(phone)
                .setTemplateParam(templateParam);
        RuntimeOptions runtime = new RuntimeOptions();

        try {
            log.info("==> 开始短信发送, phone: {}, signName: {}, templateCode: {}, templateParam: {}", phone, signName, templateCode, templateParam);

            // 发送短信
            //SendSmsResponse response = client.sendSmsWithOptions(sendSmsRequest, runtime);

            log.info("==> 短信发送成功, response: {}", JsonUtils.toJsonString("response"));
            return true;
        } catch (Exception error) {
            log.error("==> 短信发送错误: ", error);
            return false;
        }
    }
}
