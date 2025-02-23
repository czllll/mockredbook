package work.dirtsai.mockredbook.count.biz.consumer;

import com.github.phantomthief.collection.BufferTrigger;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import work.dirtsai.framework.common.util.JsonUtils;
import work.dirtsai.mockredbook.count.biz.constant.MQConstants;

import java.time.Duration;
import java.util.List;

/**
 * @description: 计数: 粉丝数
 **/
@Component
@RocketMQMessageListener(consumerGroup = "mockbook_group_" + MQConstants.TOPIC_COUNT_FANS, // Group 组
        topic = MQConstants.TOPIC_COUNT_FANS // 主题 Topic
        )
@Slf4j
public class CountFansConsumer implements RocketMQListener<String> { // TODO: Message

    private BufferTrigger<String> bufferTrigger = BufferTrigger.<String>batchBlocking()
            .bufferSize(50000) // 缓存队列的最大容量
            .batchSize(1000)   // 一批次最多聚合 1000 条
            .linger(Duration.ofSeconds(1)) // 多久聚合一次
            .setConsumerEx(this::consumeMessage) // 设置消费者方法
            .build();

    @Override
    public void onMessage(String body) {
        // 往 bufferTrigger 中添加元素
        bufferTrigger.enqueue(body);
        //log.info("count consume!!!!!!!!!!");
    }

    private void consumeMessage(List<String> bodys) {
        log.info("==> 聚合消息, size: {}", bodys.size());
        log.info("==> 聚合消息, {}", JsonUtils.toJsonString(bodys));
    }
}
