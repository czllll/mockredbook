package work.dirtsai.mockredbook.count.api;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.count.constant.ApiConstants;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import work.dirtsai.mockredbook.count.dto.FindNoteCountByIdReqDTO;
import work.dirtsai.mockredbook.count.dto.FindNoteCountByIdRspDTO;
import work.dirtsai.mockredbook.count.dto.FindUserCountByIdReqDTO;
import work.dirtsai.mockredbook.count.dto.FindUserCountByIdRspDTO;

@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface CountFeignApi {

    String PREFIX = "/count";

    /**
     * 查询笔记计数
     *
     * @param findNoteCountByIdReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/note/data")
    Response<FindNoteCountByIdRspDTO> findNoteCount(@RequestBody FindNoteCountByIdReqDTO findNoteCountByIdReqDTO);

    /**
     * 查询笔记计数
     *
     * @param findUserCountByIdReqDTO
     * @return
     */
    @PostMapping(value = PREFIX + "/user/data")
    Response<FindUserCountByIdRspDTO> findUserCount(@RequestBody FindUserCountByIdReqDTO findUserCountByIdReqDTO);

}
