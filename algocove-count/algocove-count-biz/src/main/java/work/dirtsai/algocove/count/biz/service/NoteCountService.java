package work.dirtsai.algocove.count.biz.service;


import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.count.dto.FindNoteCountByIdReqDTO;
import work.dirtsai.algocove.count.dto.FindNoteCountByIdRspDTO;

/**
 * @author: czl
 * @date: 2024/4/7 15:41
 * @version: v1.0.0
 * @description: 笔记计数业务
 **/
public interface NoteCountService {

    /**
     * 查询笔记计数数据
     * @param findNoteCountByIdReqDTO
     * @return
     */
    Response<FindNoteCountByIdRspDTO> findNoteCountData(FindNoteCountByIdReqDTO findNoteCountByIdReqDTO);
}
