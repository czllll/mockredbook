package work.dirtsai.algocove.note.biz.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.dirtsai.framework.biz.operationlog.aspect.ApiOperationLog;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.note.biz.model.vo.FindTopicListReqVO;
import work.dirtsai.algocove.note.biz.model.vo.FindTopicRspVO;
import work.dirtsai.algocove.note.biz.service.TopicService;

import java.util.List;

/**
 * @author czl$
 * @date 2025/4/21$
 */
@RestController
@RequestMapping("/topic")
@Slf4j
public class TopicController {
    @Resource
    private TopicService topicService;

    @PostMapping(value = "/list")
    @ApiOperationLog(description = "模糊查询话题列表")
    public Response<List<FindTopicRspVO>> findTopicList(@Validated @RequestBody FindTopicListReqVO findTopicListReqVO) {
        return topicService.findTopicList(findTopicListReqVO);
    }
}
