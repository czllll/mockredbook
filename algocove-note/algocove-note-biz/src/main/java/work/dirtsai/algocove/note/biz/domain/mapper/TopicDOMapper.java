package work.dirtsai.algocove.note.biz.domain.mapper;

import org.apache.ibatis.annotations.Param;
import work.dirtsai.algocove.note.biz.domain.dataobject.TopicDO;

import java.util.List;

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

    /**
     * 模糊名差咋后topic
     * @param keyword
     * @return
     */
    List<TopicDO> selectByLikeName(String keyword);

    List<TopicDO> selectByTopicIdIn(List<Long> topicIds);

    TopicDO selectByTopicName(String name);

    int batchInsert(@Param("newTopics") List<TopicDO> newTopics);

}