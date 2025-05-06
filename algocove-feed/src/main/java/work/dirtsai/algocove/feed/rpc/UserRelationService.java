package work.dirtsai.algocove.feed.rpc;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import work.dirtsai.algocove.user.relation.api.UserRelationFeignApi;
import work.dirtsai.algocove.user.relation.model.dto.FansPageReqDTO;
import work.dirtsai.algocove.user.relation.model.dto.FansPageRspDTO;
import work.dirtsai.framework.common.response.Response;

/**
 * @author czl$
 * @date 2025/5/4$
 */
@Component

public class UserRelationService {

    @Resource
    private UserRelationFeignApi userRelationFeignApi;

    public Response<FansPageRspDTO> getFansPage(FansPageReqDTO fansPageReqDTO) {
        return userRelationFeignApi.getFansPage(fansPageReqDTO);
    }
}
