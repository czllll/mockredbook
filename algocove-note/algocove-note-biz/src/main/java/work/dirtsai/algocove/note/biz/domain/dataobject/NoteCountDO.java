package work.dirtsai.algocove.note.biz.domain.dataobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author czl$
 * @date 2025/4/21$
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoteCountDO {
    private Long id;

    private Long noteId;

    private Long likeTotal;

    private Long collectTotal;

    private Long commentTotal;

}