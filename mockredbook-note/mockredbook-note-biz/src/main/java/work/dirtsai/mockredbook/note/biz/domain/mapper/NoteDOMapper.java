package work.dirtsai.mockredbook.note.biz.domain.mapper;

import org.apache.ibatis.annotations.Param;
import work.dirtsai.mockredbook.note.biz.domain.dataobject.NoteDO;

import java.util.List;

public interface NoteDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoteDO record);

    int insertSelective(NoteDO record);

    NoteDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(NoteDO record);

    int updateByPrimaryKey(NoteDO record);

    int updateVisibleOnlyMe(NoteDO noteDO);

    int updateIsTop(NoteDO noteDO);

    int selectCountByNoteId(Long noteId);

    /**
     * 查询笔记的发布者用户 ID
     * @param noteId
     * @return
     */
    Long selectCreatorIdByNoteId(Long noteId);

    /**
     * 根据channel ID 查询笔记数
     * @param ChannelId
     * @return
     */
    int selectCountByChannelId(Long ChannelId);

    /**
     * 返回同ChannelID的分页列表
     * @param channelId
     * @param offset
     * @param pageSize
     * @return
     */
    List<NoteDO> selectPageList(@Param("channelId") Long channelId,
                                @Param("offset") long offset,
                                @Param("pageSize") long pageSize);

    int selectTotalCountByCreatorId(Long creatorId);

    List<NoteDO> selectPageListByCreatorId(@Param("creatorId") Long creatorId,
                                           @Param("offset") long offset,
                                           @Param("pageSize") long pageSize);

    List<NoteDO> selectByNoteIds(@Param("noteIds") List<Long> noteIds);

}