package work.dirtsai.mockredbook.comment.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: czl
 * 
 * @date: 2023-08-15 10:33
 * @description: 评论点赞、取消点赞 Type
 **/
@Getter
@AllArgsConstructor
public enum LikeUnlikeCommentTypeEnum {
    // 点赞
    LIKE(1),
    // 取消点赞
    UNLIKE(0),
    ;

    private final Integer code;

}
