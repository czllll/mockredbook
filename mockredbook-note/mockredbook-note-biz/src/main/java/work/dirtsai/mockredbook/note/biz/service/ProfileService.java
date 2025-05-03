package work.dirtsai.mockredbook.note.biz.service;

import work.dirtsai.framework.common.response.PageResponse;
import work.dirtsai.mockredbook.note.biz.model.vo.FindProfileNotePageListReqVO;
import work.dirtsai.mockredbook.note.biz.model.vo.FindProfileNoteRspVO;

/**
 * @author czl$
 * @date 2025/4/21$
 */

public interface ProfileService {
    PageResponse<FindProfileNoteRspVO> findNoteList(FindProfileNotePageListReqVO findProfileNotePageListReqVO);

}
