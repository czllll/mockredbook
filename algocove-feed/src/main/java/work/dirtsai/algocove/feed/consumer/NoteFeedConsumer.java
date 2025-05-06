package work.dirtsai.algocove.feed.consumer;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import work.dirtsai.algocove.feed.constant.MQConstants;
import work.dirtsai.algocove.feed.model.dto.FeedFollowingMqDTO;
import work.dirtsai.algocove.feed.rpc.UserCountService;
import work.dirtsai.algocove.user.relation.api.UserRelationFeignApi;
import work.dirtsai.algocove.user.relation.model.dto.FansPageReqDTO;
import work.dirtsai.algocove.user.relation.model.dto.FansPageRspDTO;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.framework.common.util.JsonUtils;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.List;

@Slf4j
@RocketMQMessageListener(
        consumerGroup = "mockbook_group_" + MQConstants.TOPIC_NOTE_FEED,
        topic = MQConstants.TOPIC_NOTE_FEED,
        consumeMode = ConsumeMode.CONCURRENTLY
)
@Component
public class NoteFeedConsumer implements RocketMQListener<String> {

    @Resource
    UserCountService userCountService;

    static int FANS_COUNT_THRESHOLD = 50000;
    static int PAGE_SIZE = 1000;

    @Resource
    UserRelationFeignApi userRelationFeignApi;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void onMessage(String message) {
        try {
            log.info("==> NoteFeedConsumer 收到原始消息: {}", message);

            // 将接收到的JSON字符串转换为DTO对象
            FeedFollowingMqDTO feedFollowingMqDTO = JsonUtils.parseObject(message, FeedFollowingMqDTO.class);

            log.info("==> NoteFeedConsumer 消费了 FeedFollowingMqDTO: {}", feedFollowingMqDTO);

            Long creatorId = feedFollowingMqDTO.getCreatorId();
            LocalDateTime noteTime = feedFollowingMqDTO.getCreateTime();
            Long noteId = feedFollowingMqDTO.getNoteId();

            Long fansCount = userCountService.getUserFansCount(creatorId);

            if (fansCount <= FANS_COUNT_THRESHOLD) {
                Long cursor = null;
                FansPageReqDTO fansPageReqDTO = FansPageReqDTO.builder()
                        .cursor(cursor)
                        .limit(PAGE_SIZE)
                        .creatorId(creatorId).build();
                Response<FansPageRspDTO> page;

                do {
                    page = userRelationFeignApi.getFansPage(fansPageReqDTO);
                    log.info("page=》",page);
                    List<Long> fansIds = page.getData().getFansIds();
                    cursor = page.getData().getNextCursor();
                    fansPageReqDTO.setCursor(cursor);
                    batchWriteToTimeline(fansIds, noteId, noteTime);
                } while (page.getData().getHasMore());

                log.info("普通作者 note {} 扇出到 {} 个粉丝", noteId, fansCount);
            } else {
                String hotKey = "hot_author:" + noteId;
                redisTemplate.opsForValue().set(hotKey, "1", Duration.ofHours(1));
                batchWriteToTimeline(Collections.singletonList(creatorId), noteId, noteTime);
                log.info("热点作者 note {}，不进行扇出，标记为拉模式", noteId);
            }
        } catch (Exception e) {
            log.error("==> NoteFeedConsumer 处理消息异常", e);
        }
    }

    public void batchWriteToTimeline(List<Long> fansIds, Long noteId, LocalDateTime noteTime) {
        long score = noteTime.toInstant(ZoneOffset.UTC).toEpochMilli();

        redisTemplate.executePipelined((RedisCallback<Object>) connection -> {
            for (Long userId : fansIds) {
                String key = "timeline:" + userId;
                byte[] k = key.getBytes(StandardCharsets.UTF_8);
                byte[] v = String.valueOf(noteId).getBytes(StandardCharsets.UTF_8);

                connection.zAdd(k, score, v);
                connection.zRemRange(k, 0, -1001);
            }
            return null;
        });

        log.info("note {} 扇出到 {} 个粉丝 timeline", noteId, fansIds.size());
    }

    @PostConstruct
    public void logInit() {
        log.info("✅ NoteFeedConsumer 被 Spring 注册：topic={}, group={}", MQConstants.TOPIC_NOTE_FEED, "mockbook_group_" + MQConstants.TOPIC_NOTE_FEED);
    }
}