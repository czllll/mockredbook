package work.dirtsai.mockredbook.comment.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: czl
 * @date: 2024/4/7 15:17
 * @version: v1.0.0
 * @description: 评论点赞
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LikeCommentReqVO {

    @NotNull(message = "评论 ID 不能为空")
    private Long commentId;

}
