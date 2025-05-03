package work.dirtsai.mockredbook.user.biz.domain.mapper;

import work.dirtsai.mockredbook.user.biz.domain.dataobject.UserCountDO;

/**
 * @author czl$
 * @date 2025/4/21$
 */

public interface UserCountDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserCountDO record);

    int insertSelective(UserCountDO record);

    UserCountDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserCountDO record);

    int updateByPrimaryKey(UserCountDO record);
}