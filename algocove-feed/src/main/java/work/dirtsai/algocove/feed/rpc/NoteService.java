package work.dirtsai.algocove.feed.rpc;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import work.dirtsai.algocove.note.api.NoteServiceApi;
import work.dirtsai.algocove.note.model.dto.FindFollowingNoteRspVO;

import java.util.List;

/**
 * @author czl$
 * @date 2025/5/5$
 */
@Component

public class NoteService {
    @Resource
    private NoteServiceApi noteFeignApi;

    public List<FindFollowingNoteRspVO> getNotesByNoteIds(List<Long> noteIdList) {
        return noteFeignApi.getNotesByUserIds(noteIdList);
    }
}
