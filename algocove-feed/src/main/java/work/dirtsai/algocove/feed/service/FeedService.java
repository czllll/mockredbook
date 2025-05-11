package work.dirtsai.algocove.feed.service;

import work.dirtsai.algocove.feed.model.dto.PageRspDTO;
import work.dirtsai.algocove.note.model.dto.FindFollowingNoteRspVO;
import work.dirtsai.framework.common.response.Response;

/**
 * @author czl$
 * @date 2025/5/4$
 */

public interface FeedService {

    /**
     * 获取当前用户关注者的feed
     * @return FeedFollowingPageResponse
     */
    public Response<PageRspDTO<FindFollowingNoteRspVO>> getFollowingFeed(Long userId, Long cursor, Integer limit);

}
