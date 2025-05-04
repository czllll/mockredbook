package work.dirtsai.algocove.note.biz.model.vo;

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
public class FindChannelRspVO {
    /**
     * 频道 ID
     */
    private Long id;

    /**
     * 频道名称
     */
    private String name;

}
