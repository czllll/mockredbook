package work.dirtsai.algocove.feed.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.dirtsai.algocove.feed.model.dto.PageRspDTO;
import work.dirtsai.algocove.feed.model.vo.FeedFollowingReqVO;
import work.dirtsai.algocove.feed.service.FeedService;
import work.dirtsai.algocove.note.model.dto.FindFollowingNoteRspVO;
import work.dirtsai.framework.biz.context.holder.LoginUserContextHolder;
import work.dirtsai.framework.common.response.Response;

/**
 * @author czl$
 * @date 2025/5/4$
 */

@RestController
@RequestMapping("/feed")
public class FeedController {

    @Resource
    private FeedService feedService;

    @PostMapping("/following")
    public Response<PageRspDTO<FindFollowingNoteRspVO>> getFollowingFeed(@RequestBody FeedFollowingReqVO reqVO) {
        Long userId = LoginUserContextHolder.getUserId();
        return feedService.getFollowingFeed(userId, reqVO.getCursor(), reqVO.getLimit());
    }
}
