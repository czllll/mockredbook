package work.dirtsai.mockredbook.oss.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.oss.constant.ApiConstants;

@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface FileFeignApi {

    String PREFIX = "/file";

    @PostMapping(value = PREFIX + "/test")
    Response<?> test();

}