package work.dirtsai.algocove.user.relation.biz.service;

import org.springframework.web.bind.annotation.RequestParam;
import work.dirtsai.algocove.user.relation.model.dto.FansPageReqDTO;
import work.dirtsai.algocove.user.relation.model.dto.FansPageRspDTO;
import work.dirtsai.framework.common.response.PageResponse;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.user.relation.biz.model.vo.*;

import java.util.List;


public interface RelationService {

    /**
     * 关注用户
     * @param followUserReqVO
     * @return
     */
    Response<?> follow(FollowUserReqVO followUserReqVO);

    /**
     * 取关用户
     * @param unfollowUserReqVO
     * @return
     */
    Response<?> unfollow(UnfollowUserReqVO unfollowUserReqVO);

    /**
     * 查询关注列表
     * @param findFollowingListReqVO
     * @return
     */
    PageResponse<FindFollowingUserRspVO> findFollowingList(FindFollowingListReqVO findFollowingListReqVO);


    /**
     * 查询粉丝列表
     * @param findFansListReqVO
     * @return
     */
    PageResponse<FindFansUserRspVO> findFansList(FindFansListReqVO findFansListReqVO);

    /**
     * 使用游标查询粉丝列表
     */
    Response<FansPageRspDTO> getFansPage(FansPageReqDTO fansPageReqDTO);

}
