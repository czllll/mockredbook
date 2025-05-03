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
import work.dirtsai.mockredbook.count.biz.service.NoteCountService;
import work.dirtsai.mockredbook.count.dto.FindNoteCountByIdReqDTO;
import work.dirtsai.mockredbook.count.dto.FindNoteCountByIdRspDTO;


/**
 * @author: czl
 * @date: 2024/4/4 13:22
 * @version: v1.0.0
 * @description: 笔记维度计数
 **/
@RestController
@RequestMapping("/count")
@Slf4j
public class NoteCountController {

    @Resource
    private NoteCountService noteCountService;

    @PostMapping(value = "/note/data")
    @ApiOperationLog(description = "获取笔记计数数据")
    public Response<FindNoteCountByIdRspDTO> findNoteCountData(@Validated @RequestBody FindNoteCountByIdReqDTO findNoteCountByIdReqDTO) {
        return noteCountService.findNoteCountData(findNoteCountByIdReqDTO);
    }

}
