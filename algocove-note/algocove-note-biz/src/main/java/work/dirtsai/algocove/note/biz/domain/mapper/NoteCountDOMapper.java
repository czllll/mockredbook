package work.dirtsai.algocove.note.biz.domain.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import work.dirtsai.algocove.note.biz.domain.dataobject.NoteCountDO;

/**
 * @author czl$
 * @date 2025/4/21$
 */

public interface NoteCountDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(NoteCountDO record);

    int insertSelective(NoteCountDO record);

    NoteCountDO selectByPrimaryKey(Long id);

    List<NoteCountDO> selectByNoteIds(@Param("noteIds") List<Long> noteIds);

    int updateByPrimaryKeySelective(NoteCountDO record);

    int updateByPrimaryKey(NoteCountDO record);
}
