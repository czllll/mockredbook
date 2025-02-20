package work.dirtsai.mockredbook.note.biz.domain.mapper;

import work.dirtsai.mockredbook.note.biz.domain.dataobject.TopicDO;

public interface TopicDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TopicDO record);

    int insertSelective(TopicDO record);

    TopicDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TopicDO record);

    int updateByPrimaryKey(TopicDO record);

    /**
     * 根据主键ID查询话题名称
     * @param id
     * @return
     */
    String selectNameByPrimaryKey(Long id);
}