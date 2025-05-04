package work.dirtsai.algocove.note.biz.model.vo;

import jakarta.validation.constraints.NotBlank;
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
public class FindTopicListReqVO {

    @NotBlank(message = "话题关键词不能为空")
    private String keyword;

}
