package work.dirtsai.mockredbook.user.relation.biz;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import work.dirtsai.framework.common.util.JsonUtils;
import work.dirtsai.mockredbook.user.relation.biz.constant.MQConstants;
import work.dirtsai.mockredbook.user.relation.biz.enums.FollowUnfollowTypeEnum;
import work.dirtsai.mockredbook.user.relation.biz.model.dto.CountFollowUnfollowMqDTO;
import work.dirtsai.mockredbook.user.relation.biz.model.dto.FollowUserMqDTO;

import java.time.LocalDateTime;


@SpringBootTest
@Slf4j
class MQTest {

    @Resource
    private RocketMQTemplate rocketMQTemplate;


    /**
     * 测试：发送计数 MQ, 以统计粉丝数
     */
    @Test
    void testSendCountFollowUnfollowMQ() {
        // 循环发送 3200 条 MQ
        for (long i = 0; i < 3200; i++) {
            // 构建消息体 DTO
            CountFollowUnfollowMqDTO countFollowUnfollowMqDTO = CountFollowUnfollowMqDTO.builder()
                    .userId(i+1) // 关注者用户 ID
                    .targetUserId(27L) // 目标用户
                    .type(FollowUnfollowTypeEnum.FOLLOW.getCode())
                    .build();

            // 构建消息对象，并将 DTO 转成 Json 字符串设置到消息体中
            org.springframework.messaging.Message<String> message = MessageBuilder.withPayload(JsonUtils.toJsonString(countFollowUnfollowMqDTO))
                    .build();

            // 发送 MQ 通知计数服务：统计粉丝数
            rocketMQTemplate.asyncSend(MQConstants.TOPIC_COUNT_FANS, message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("==> 【计数服务：粉丝数】MQ 发送成功，SendResult: {}", sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    log.error("==> 【计数服务：粉丝数】MQ 发送异常: ", throwable);
                }
            });
        }

    }
    /**
     * 测试：发送一万条 MQ
     */
    @Test
    void testBatchSendMQ() {
        for (long i = 0; i < 1000; i++) {
            // 构建消息体 DTO
            FollowUserMqDTO followUserMqDTO = FollowUserMqDTO.builder()
                    .userId(i)
                    .followUserId(i)
                    .createTime(LocalDateTime.now())
                    .build();

            // 构建消息对象，并将 DTO 转成 Json 字符串设置到消息体中
            Message<String> message = MessageBuilder.withPayload(JsonUtils.toJsonString(followUserMqDTO))
                    .build();

            // 通过冒号连接, 可让 MQ 发送给主题 Topic 时，携带上标签 Tag
            String destination = MQConstants.TOPIC_FOLLOW_OR_UNFOLLOW + ":" + MQConstants.TAG_FOLLOW;

            log.info("==> 开始发送关注操作 MQ, 消息体: {}", followUserMqDTO);

            // 异步发送 MQ 消息，提升接口响应速度
            rocketMQTemplate.asyncSend(destination, message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("==> MQ 发送成功，SendResult: {}", sendResult);
                }

                @Override
                public void onException(Throwable throwable) {
                    log.error("==> MQ 发送异常: ", throwable);
                }
            });
        }
    }

}

