package work.dirtsai.mockredbook.note.biz.service;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.note.biz.model.vo.FindNoteDetailReqVO;
import work.dirtsai.mockredbook.note.biz.model.vo.FindNoteDetailRespVO;
import work.dirtsai.mockredbook.note.biz.model.vo.PublishNoteReqVO;
import work.dirtsai.mockredbook.note.biz.model.vo.UpdateNoteReqVO;

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

    /**
     * 笔记详情
     * @param findNoteDetailReqVO
     * @return
     */
    Response<FindNoteDetailRespVO> findNoteDetail(FindNoteDetailReqVO findNoteDetailReqVO);

    /**
     * 笔记更新
     * @param updateNoteReqVO
     * @return
     */
    Response<?> updateNote(UpdateNoteReqVO updateNoteReqVO);

}
