package work.dirtsai.mockredbook.kv.biz.controller;

import org.springframework.web.bind.annotation.RestController;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import work.dirtsai.mockredbook.kv.biz.service.NoteContentService;
import work.dirtsai.mockredbook.kv.dto.req.AddNoteContentReqDTO;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.kv.dto.req.DeleteNoteContentReqDTO;
import work.dirtsai.mockredbook.kv.dto.req.FindNoteContentReqDTO;
import work.dirtsai.mockredbook.kv.dto.resp.FindNoteContentRespDTO;

@RestController
@RequestMapping("/kv")
@Slf4j
public class NoteContentController {

    @Resource
    private NoteContentService noteContentService;

    @PostMapping(value = "/note/content/add")
    public Response<?> addNoteContent(@Validated @RequestBody AddNoteContentReqDTO addNoteContentReqDTO) {
        return noteContentService.addNoteContent(addNoteContentReqDTO);
    }

    @PostMapping(value = "/note/content/find")
    public Response<FindNoteContentRespDTO> findNoteContent(@Validated @RequestBody FindNoteContentReqDTO findNoteContentReqDTO) {
        return noteContentService.findNoteContent(findNoteContentReqDTO);
    }

    @PostMapping(value = "/note/content/delete")
    public Response<?> deleteNoteContent(@Validated @RequestBody DeleteNoteContentReqDTO deleteNoteContentReqDTO) {
        return noteContentService.deleteNoteContent(deleteNoteContentReqDTO);
    }

}