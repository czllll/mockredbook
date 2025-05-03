package work.dirtsai.mockredbook.note.biz.service;

import work.dirtsai.framework.common.response.PageResponse;
import work.dirtsai.mockredbook.note.biz.model.vo.FindDiscoverNotePageListReqVO;
import work.dirtsai.mockredbook.note.biz.model.vo.FindDiscoverNoteRspVO;

public interface DiscoverService {
    PageResponse<FindDiscoverNoteRspVO> findNoteList(FindDiscoverNotePageListReqVO findDiscoverNoteListReqVO);
}
