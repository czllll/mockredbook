package work.dirtsai.mockredbook.user.relation.biz.service;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.user.relation.biz.model.vo.FollowUserReqVO;

public interface RelationService {

    /**
     * 关注用户
     * @param followUserReqVO
     * @return
     */
    Response<?> follow(FollowUserReqVO followUserReqVO);

}
