package work.dirtsai.algocove.feed.service.impl;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import work.dirtsai.algocove.feed.model.dto.PageRspDTO;
import work.dirtsai.algocove.note.biz.model.vo.FindDiscoverNoteRspVO;
import work.dirtsai.algocove.feed.rpc.NoteService;
import work.dirtsai.algocove.feed.service.FeedService;
import work.dirtsai.framework.common.response.Response;

import java.util.List;
import java.util.Set;

/**
 * @author czl$
 * @date 2025/5/4$
 */

@Service
public class FeedServiceImpl implements FeedService {

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    NoteService noteService;

    @Override
    public Response<PageRspDTO<FindDiscoverNoteRspVO>> getFollowingFeed(Long userId, Long cursor, Integer limit) {
        String key = "timeline:" + userId;

        // 1. 拉取 Redis 中的 noteId（按时间倒序，游标分页）
        // 构造 Redis 分数区间
        double maxScore = (cursor == null) ? Double.POSITIVE_INFINITY : cursor.doubleValue();
        double minScore = 0;

        // 查询 Redis 中的 noteId（ZREVRANGEBYSCORE，按时间倒序）
        Set<Object> rawNoteIds = redisTemplate.opsForZSet()
                .reverseRangeByScore(key, minScore, maxScore, 0, limit);

        List<Long> noteIds = rawNoteIds.stream()
                .map(obj -> obj instanceof Long ? (Long) obj : Long.valueOf(obj.toString()))
                .toList();


        // 2. 不足 limit → 尝试触发回补逻辑（从 DB timeline 表回补 Redis）
        if (noteIds.size() < limit) {
//            timelineBackfillService.backfillTimelineIfNeeded(userId, cursor);
//            noteIds = redisTimelineService.queryNoteIdsFromTimeline(key, cursor, limit); // 再查一次
        }

        // 3. 转换为 Long，并根据 noteId 查询帖子详情（注意顺序）
        List<Long> noteIdList = noteIds.stream().map(Long::valueOf).toList();
        List<FindDiscoverNoteRspVO> noteVOList = noteService.getNotesByNoteIds(noteIdList);

        // 4. 计算 nextCursor & hasMore
        Long nextCursor = noteIdList.isEmpty() ? null : noteIdList.get(noteIdList.size() - 1);
        boolean hasMore = noteIdList.size() == limit;

        // 5. 返回分页响应体
        return Response.success(PageRspDTO.<FindDiscoverNoteRspVO>builder()
                .list(noteVOList)
                .nextCursor(nextCursor)
                .hasMore(hasMore)
                .build()) ;
    }

}
