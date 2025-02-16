package work.dirtsai.mockredbook.auth.alarm;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import work.dirtsai.mockredbook.auth.alarm.impl.MailAlarmHelper;
import work.dirtsai.mockredbook.auth.alarm.impl.SmsAlarmHelper;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@RefreshScope
@Configuration
public class AlarmConfig {

    @Value("${alarm.type}")
    private String alarmType;

    @RefreshScope
    @Bean
    public AlarmInterface alarmHelper() {
        // 根据配置文件中的告警类型，初始化选择不同的告警实现类
        if (StringUtils.equals("sms", alarmType)) {
            return new SmsAlarmHelper();
        } else if (StringUtils.equals("mail", alarmType)) {
            return new MailAlarmHelper();
        } else {
            throw new IllegalArgumentException("错误的告警类型...");
        }
    }
}

