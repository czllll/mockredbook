package work.dirtsai.mockredbook.user.relation.biz.domain.mapper;

import org.apache.ibatis.annotations.Param;
import work.dirtsai.mockredbook.user.relation.biz.domain.dataobject.FansDO;

public interface FansDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FansDO record);

    int insertSelective(FansDO record);

    FansDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FansDO record);

    int updateByPrimaryKey(FansDO record);

    int deleteByUserIdAndFansUserId(@Param("userId") Long userId,
                                    @Param("fansUserId") Long fansUserId);
}