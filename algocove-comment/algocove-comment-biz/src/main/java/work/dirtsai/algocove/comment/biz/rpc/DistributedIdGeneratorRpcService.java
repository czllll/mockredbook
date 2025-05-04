package work.dirtsai.algocove.comment.biz.rpc;

import work.dirtsai.algocove.distributed.id.generator.api.DistributedIdGeneratorFeignApi;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * @author: czl
 * @date: 2024/4/13 23:29
 * @version: v1.0.0
 * @description: 分布式 ID 服务
 **/
@Component
public class DistributedIdGeneratorRpcService {

    @Resource
    private DistributedIdGeneratorFeignApi distributedIdGeneratorFeignApi;

    /**
     * 生成评论 ID
     *
     * @return
     */
    public String generateCommentId() {
        return distributedIdGeneratorFeignApi.getSegmentId("leaf-segment-comment-id");
    }

}
