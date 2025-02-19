package work.dirtsai.mockredbook.kv.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.kv.constant.ApiConstants;
import work.dirtsai.mockredbook.kv.dto.req.AddNoteContentReqDTO;
import work.dirtsai.mockredbook.kv.dto.req.DeleteNoteContentReqDTO;
import work.dirtsai.mockredbook.kv.dto.req.FindNoteContentReqDTO;
import work.dirtsai.mockredbook.kv.dto.resp.FindNoteContentRespDTO;

@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface KeyValueFeignApi {

    String PREFIX = "/kv";

    @PostMapping(value = PREFIX + "/note/content/add")
    Response<?> addNoteContent(@RequestBody AddNoteContentReqDTO addNoteContentReqDTO);


    @PostMapping(value = PREFIX + "/note/content/find")
    Response<FindNoteContentRespDTO> findNoteContent(@RequestBody FindNoteContentReqDTO findNoteContentReqDTO);

    @PostMapping(value = PREFIX + "/note/content/delete")
    Response<?> deleteNoteContent(@RequestBody DeleteNoteContentReqDTO deleteNoteContentReqDTO);

}