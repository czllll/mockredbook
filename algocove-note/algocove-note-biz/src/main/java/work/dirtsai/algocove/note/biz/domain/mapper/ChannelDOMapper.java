package work.dirtsai.algocove.note.biz.domain.mapper;

import work.dirtsai.algocove.note.biz.domain.dataobject.ChannelDO;

import java.util.List;

public interface ChannelDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChannelDO record);

    int insertSelective(ChannelDO record);

    ChannelDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChannelDO record);

    int updateByPrimaryKey(ChannelDO record);

    List<ChannelDO> selectAll();

}