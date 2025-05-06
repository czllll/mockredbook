package work.dirtsai.algocove.note.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author czl$
 * @date 2025/5/5$
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NotePageReqDTO {
    private List<Long> userIds;  // 关注的 up 列表
    private Long cursor;         // 游标时间戳（用于分页）
    private Integer limit;       // 每页条数
}
