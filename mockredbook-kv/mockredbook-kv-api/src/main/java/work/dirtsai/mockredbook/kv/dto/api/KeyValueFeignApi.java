package work.dirtsai.mockredbook.kv.dto.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.kv.dto.constant.ApiConstants;
import work.dirtsai.mockredbook.kv.dto.req.AddNoteContentReqDTO;

@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface KeyValueFeignApi {

    String PREFIX = "/kv";

    @PostMapping(value = PREFIX + "/note/content/add")
    Response<?> addNoteContent(@RequestBody AddNoteContentReqDTO addNoteContentReqDTO);

}