package work.dirtsai.algocove.note.biz.service;

import work.dirtsai.framework.common.response.PageResponse;
import work.dirtsai.algocove.note.biz.model.vo.FindDiscoverNotePageListReqVO;
import work.dirtsai.algocove.note.biz.model.vo.FindDiscoverNoteRspVO;

public interface DiscoverService {
    PageResponse<FindDiscoverNoteRspVO> findNoteList(FindDiscoverNotePageListReqVO findDiscoverNoteListReqVO);
}
