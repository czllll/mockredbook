package work.dirtsai.algocove.note.biz.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.dirtsai.framework.biz.operationlog.aspect.ApiOperationLog;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.note.biz.model.vo.FindChannelRspVO;
import work.dirtsai.algocove.note.biz.service.ChannelService;

import java.util.List;

/**
 * @author czl$
 * @date 2025/4/21$
 */

@RestController
@RequestMapping("/channel")
@Slf4j
public class ChannelController {

    @Resource
    private ChannelService channelService;

    @PostMapping(value = "/list")
    @ApiOperationLog(description = "获取所有频道")
    public Response<List<FindChannelRspVO>> findChannelList() {
        return channelService.findChannelList();
    }

}
