package work.dirtsai.mockredbook.user.relation.biz.service;

import work.dirtsai.framework.common.response.PageResponse;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.user.relation.biz.model.vo.FindFollowingListReqVO;
import work.dirtsai.mockredbook.user.relation.biz.model.vo.FindFollowingUserRspVO;
import work.dirtsai.mockredbook.user.relation.biz.model.vo.FollowUserReqVO;
import work.dirtsai.mockredbook.user.relation.biz.model.vo.UnfollowUserReqVO;


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

}
