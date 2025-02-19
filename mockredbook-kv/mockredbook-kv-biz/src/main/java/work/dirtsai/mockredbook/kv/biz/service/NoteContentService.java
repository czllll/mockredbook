package work.dirtsai.mockredbook.kv.biz.service;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.kv.dto.req.AddNoteContentReqDTO;
import work.dirtsai.mockredbook.kv.dto.req.FindNoteContentReqDTO;
import work.dirtsai.mockredbook.kv.dto.resp.FindNoteContentRespDTO;

/**
 * 笔记内容存储
 */
public interface NoteContentService {

    /**
     * 添加笔记内容
     *
     * @param addNoteContentReqDTO
     * @return
     */
    Response<?> addNoteContent(AddNoteContentReqDTO addNoteContentReqDTO);

    /**
     * 查询笔记内容
     *
     * @param findNoteContentReqDTO
     * @return
     */
    Response<FindNoteContentRespDTO> findNoteContent(FindNoteContentReqDTO findNoteContentReqDTO);
}