package work.dirtsai.mockredbook.count.biz.controller;


import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.dirtsai.framework.biz.operationlog.aspect.ApiOperationLog;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.count.biz.service.UserCountService;
import work.dirtsai.mockredbook.count.dto.FindUserCountByIdReqDTO;
import work.dirtsai.mockredbook.count.dto.FindUserCountByIdRspDTO;

/**
 * @author: czl
 * @date: 2024/4/4 13:22
 * @version: v1.0.0
 * @description: 用户维度计数
 **/
@RestController
@RequestMapping("/count")
@Slf4j
public class UserCountController {

    @Resource
    private UserCountService userCountService;

    @PostMapping(value = "/user/data")
    @ApiOperationLog(description = "获取用户计数数据")
    public Response<FindUserCountByIdRspDTO> findUserCountData(@Validated @RequestBody FindUserCountByIdReqDTO findUserCountByIdReqDTO) {
        return userCountService.findUserCountData(findUserCountByIdReqDTO);
    }

}
