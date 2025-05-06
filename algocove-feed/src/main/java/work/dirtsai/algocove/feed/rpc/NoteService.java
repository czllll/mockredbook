package work.dirtsai.algocove.feed.rpc;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import work.dirtsai.algocove.count.api.CountFeignApi;
import work.dirtsai.algocove.note.api.NoteServiceApi;
import work.dirtsai.algocove.note.biz.model.vo.FindDiscoverNoteRspVO;
import work.dirtsai.framework.common.response.PageResponse;

import java.util.List;

/**
 * @author czl$
 * @date 2025/5/5$
 */
@Component

public class NoteService {
    @Resource
    private NoteServiceApi noteFeignApi;

    public List<FindDiscoverNoteRspVO> getNotesByNoteIds(List<Long> noteIdList) {
        return noteFeignApi.getNotesByUserIds(noteIdList);
    }
}
