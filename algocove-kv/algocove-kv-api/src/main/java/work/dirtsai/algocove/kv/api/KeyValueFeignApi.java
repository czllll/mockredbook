package work.dirtsai.algocove.kv.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.kv.constant.ApiConstants;
import work.dirtsai.algocove.kv.dto.req.*;
import work.dirtsai.algocove.kv.dto.resp.FindCommentContentRspDTO;
import work.dirtsai.algocove.kv.dto.resp.FindNoteContentRespDTO;

import java.util.List;

@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface KeyValueFeignApi {

    String PREFIX = "/kv";

    @PostMapping(value = PREFIX + "/note/content/add")
    Response<?> addNoteContent(@RequestBody AddNoteContentReqDTO addNoteContentReqDTO);


    @PostMapping(value = PREFIX + "/note/content/find")
    Response<FindNoteContentRespDTO> findNoteContent(@RequestBody FindNoteContentReqDTO findNoteContentReqDTO);

    @PostMapping(value = PREFIX + "/note/content/delete")
    Response<?> deleteNoteContent(@RequestBody DeleteNoteContentReqDTO deleteNoteContentReqDTO);


    @PostMapping(value = PREFIX + "/comment/content/batchAdd")
    Response<?> batchAddCommentContent(@RequestBody BatchAddCommentContentReqDTO batchAddCommentContentReqDTO);

    @PostMapping(value = PREFIX + "/comment/content/batchFind")
    Response<List<FindCommentContentRspDTO>> batchFindCommentContent(@RequestBody BatchFindCommentContentReqDTO batchFindCommentContentReqDTO);

    @PostMapping(value = PREFIX + "/comment/content/delete")
    Response<?> deleteCommentContent(@RequestBody DeleteCommentContentReqDTO deleteCommentContentReqDTO);

}