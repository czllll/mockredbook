package work.dirtsai.algocove.user.relation.biz.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import work.dirtsai.algocove.user.relation.model.dto.FansPageReqDTO;
import work.dirtsai.algocove.user.relation.model.dto.FansPageRspDTO;
import work.dirtsai.framework.biz.operationlog.aspect.ApiOperationLog;
import work.dirtsai.framework.common.response.PageResponse;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.user.relation.biz.model.vo.*;
import work.dirtsai.algocove.user.relation.biz.service.RelationService;

import java.util.List;


@RestController
@RequestMapping("/relation")
@Slf4j
public class RelationController {

    @Resource
    private RelationService relationService;

    @PostMapping("/follow")
    @ApiOperationLog(description = "关注用户")
    public Response<?> follow(@Validated @RequestBody FollowUserReqVO followUserReqVO) {
        return relationService.follow(followUserReqVO);
    }

    @PostMapping("/unfollow")
    @ApiOperationLog(description = "取关用户")
    public Response<?> unfollow(@Validated @RequestBody UnfollowUserReqVO unfollowUserReqVO) {
        return relationService.unfollow(unfollowUserReqVO);
    }

    @PostMapping("/following/list")
    @ApiOperationLog(description = "查询用户关注列表")
    public PageResponse<FindFollowingUserRspVO> findFollowingList(@Validated @RequestBody FindFollowingListReqVO findFollowingListReqVO) {
        return relationService.findFollowingList(findFollowingListReqVO);


    }
    @PostMapping("/fans/list")
    @ApiOperationLog(description = "查询用户粉丝列表")
    public PageResponse<FindFansUserRspVO> findFansList(@Validated @RequestBody FindFansListReqVO findFansListReqVO) {
        return relationService.findFansList(findFansListReqVO);
    }

    //===================feign===================
    @PostMapping("/fans/page")
    Response<FansPageRspDTO> getFansPage(@RequestBody FansPageReqDTO fansPageReqDTO){
        return relationService.getFansPage(fansPageReqDTO);
    }


}