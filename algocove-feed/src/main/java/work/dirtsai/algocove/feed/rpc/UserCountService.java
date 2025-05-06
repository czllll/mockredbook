package work.dirtsai.algocove.feed.rpc;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import work.dirtsai.algocove.count.api.CountFeignApi;
import work.dirtsai.framework.common.response.Response;

/**
 * @author czl$
 * @date 2025/5/4$
 */

@Component
public class UserCountService {
    @Resource
    private CountFeignApi countFeignApi;

    public Long getUserFansCount(Long creatorId) {
        return countFeignApi.getFansCountByCreatorId(creatorId);
    }
}
