package work.dirtsai.mockredbook.user.relation.biz.domain.mapper;

import org.apache.ibatis.annotations.Param;
import work.dirtsai.mockredbook.user.relation.biz.domain.dataobject.FollowingDO;

import java.util.List;

public interface FollowingDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FollowingDO record);

    int insertSelective(FollowingDO record);

    FollowingDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FollowingDO record);

    int updateByPrimaryKey(FollowingDO record);

    List<FollowingDO> selectByUserId(Long userId);

    int deleteByUserIdAndFollowingUserId(@Param("userId") Long userId,
                                         @Param("unfollowUserId") Long unfollowUserId);
}