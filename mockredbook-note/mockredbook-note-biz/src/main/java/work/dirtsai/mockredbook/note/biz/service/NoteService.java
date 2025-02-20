package work.dirtsai.mockredbook.note.biz.service;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.note.biz.model.vo.PublishNoteReqVO;

/**
 * 笔记业务
 */
public interface NoteService {

    /**
     * 笔记发布
     * @param publishNoteReqVO
     * @return
     */
    Response<?> publishNote(PublishNoteReqVO publishNoteReqVO);

}
