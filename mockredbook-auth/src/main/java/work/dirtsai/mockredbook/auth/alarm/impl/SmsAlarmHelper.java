package work.dirtsai.mockredbook.auth.alarm.impl;

import lombok.extern.slf4j.Slf4j;
import work.dirtsai.mockredbook.auth.alarm.AlarmInterface;

@Slf4j
public class SmsAlarmHelper implements AlarmInterface {

    /**
     * 发送告警信息
     *
     * @param message
     * @return
     */
    @Override
    public boolean send(String message) {
        log.info("==> 【短信告警】：{}", message);

        // 业务逻辑...

        return true;
    }
}

