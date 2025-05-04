package work.dirtsai.algocove.count.biz.consumer;

import cn.hutool.core.collection.CollUtil;
import com.google.common.util.concurrent.RateLimiter;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import work.dirtsai.framework.common.util.JsonUtils;
import work.dirtsai.algocove.count.biz.constant.MQConstants;
import work.dirtsai.algocove.count.biz.domain.mapper.CommentDOMapper;
import work.dirtsai.algocove.count.biz.model.dto.AggregationCountLikeUnlikeCommentMqDTO;

import java.util.List;

/**
 * @author: 犬小哈
 * @date: 2024/8/9 11:52
 * @version: v1.0.0
 * @description: 计数: 评论点赞数落库
 **/
@Component
@RocketMQMessageListener(consumerGroup = "xiaohashu_group_" + MQConstants.TOPIC_COUNT_COMMENT_LIKE_2_DB, // Group 组
        topic = MQConstants.TOPIC_COUNT_COMMENT_LIKE_2_DB // 主题 Topic
        )
@Slf4j
public class CountCommentLike2DBConsumer implements RocketMQListener<String> {

    @Resource
    private CommentDOMapper commentDOMapper;

    // 每秒创建 5000 个令牌
    private RateLimiter rateLimiter = RateLimiter.create(5000);

    @Override
    public void onMessage(String body) {
        // 流量削峰：通过获取令牌，如果没有令牌可用，将阻塞，直到获得
        rateLimiter.acquire();

        log.info("## 消费到了 MQ 【计数: 评论点赞数入库】, {}...", body);

        List<AggregationCountLikeUnlikeCommentMqDTO> countList = null;
        try {
            countList = JsonUtils.parseList(body, AggregationCountLikeUnlikeCommentMqDTO.class);
        } catch (Exception e) {
            log.error("## 解析 JSON 字符串异常", e);
        }

        if (CollUtil.isNotEmpty(countList)) {
            // 更新评论点赞数
            countList.forEach(item -> {
                Long commentId = item.getCommentId();
                Integer count = item.getCount();

                commentDOMapper.updateLikeTotalByCommentId(count, commentId);
            });
        }
    }

}
