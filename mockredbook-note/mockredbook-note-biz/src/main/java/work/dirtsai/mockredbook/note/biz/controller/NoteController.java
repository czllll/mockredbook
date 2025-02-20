package work.dirtsai.mockredbook.note.biz.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.dirtsai.framework.biz.operationlog.aspect.ApiOperationLog;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.note.biz.model.vo.FindNoteDetailReqVO;
import work.dirtsai.mockredbook.note.biz.model.vo.FindNoteDetailRespVO;
import work.dirtsai.mockredbook.note.biz.model.vo.PublishNoteReqVO;
import work.dirtsai.mockredbook.note.biz.model.vo.UpdateNoteReqVO;
import work.dirtsai.mockredbook.note.biz.service.NoteService;

@RestController
@RequestMapping("/note")
@Slf4j
public class NoteController {

    @Resource
    private NoteService noteService;

    @PostMapping(value = "/publish")
    @ApiOperationLog(description = "笔记发布")
    public Response<?> publishNote(@Validated @RequestBody PublishNoteReqVO publishNoteReqVO) {
        return noteService.publishNote(publishNoteReqVO);
    }

    @PostMapping(value = "/detail")
    @ApiOperationLog(description = "笔记详情")
    public Response<FindNoteDetailRespVO> findNoteDetail(@Validated @RequestBody FindNoteDetailReqVO findNoteDetailReqVO) {
        return noteService.findNoteDetail(findNoteDetailReqVO);
    }

    @PostMapping(value = "/update")
    @ApiOperationLog(description = "笔记修改")
    public Response<?> updateNote(@Validated @RequestBody UpdateNoteReqVO updateNoteReqVO) {
        return noteService.updateNote(updateNoteReqVO);
    }

}