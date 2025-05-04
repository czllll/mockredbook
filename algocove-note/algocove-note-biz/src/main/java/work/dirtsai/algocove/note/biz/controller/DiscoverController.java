package work.dirtsai.algocove.note.biz.controller;

import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.dirtsai.framework.common.response.PageResponse;
import work.dirtsai.algocove.note.biz.model.vo.FindDiscoverNotePageListReqVO;
import work.dirtsai.algocove.note.biz.model.vo.FindDiscoverNoteRspVO;
import work.dirtsai.algocove.note.biz.service.DiscoverService;

/**
 * @author czl$
 * @date 2025/4/21$
 * @description 发现页面-即首页
 */

@RestController
@RequestMapping("/discover")
public class DiscoverController {

    @Resource
    private DiscoverService discoverService;

    @PostMapping("/note/list")
    public PageResponse<FindDiscoverNoteRspVO> findList(@Validated @RequestBody FindDiscoverNotePageListReqVO findDiscoverNotePageListReqVO){
        return discoverService.findNoteList(findDiscoverNotePageListReqVO);
    }
}
