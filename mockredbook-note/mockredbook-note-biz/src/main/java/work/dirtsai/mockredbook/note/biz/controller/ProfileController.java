package work.dirtsai.mockredbook.note.biz.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.dirtsai.framework.biz.operationlog.aspect.ApiOperationLog;
import work.dirtsai.framework.common.response.PageResponse;
import work.dirtsai.mockredbook.note.biz.model.vo.FindProfileNotePageListReqVO;
import work.dirtsai.mockredbook.note.biz.model.vo.FindProfileNoteRspVO;
import work.dirtsai.mockredbook.note.biz.service.ProfileService;

/**
 * @author czl$
 * @date 2025/4/21$
 */
@RestController
@RequestMapping("/profile")
@Slf4j
public class ProfileController {
    @Resource
    private ProfileService profileService;

    @PostMapping(value = "/note/list")
    @ApiOperationLog(description = "个人主页-查询笔记列表")
    public PageResponse<FindProfileNoteRspVO> findNoteList(@Validated @RequestBody FindProfileNotePageListReqVO findProfileNotePageListReqVO) {
        return profileService.findNoteList(findProfileNotePageListReqVO);
    }

}
