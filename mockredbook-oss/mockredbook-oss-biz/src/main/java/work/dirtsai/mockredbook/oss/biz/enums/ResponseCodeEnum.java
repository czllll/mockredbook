package work.dirtsai.mockredbook.oss.biz.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import work.dirtsai.framework.common.exception.BaseExceptionInterface;

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR("OSS-10000", "出错啦，后台小哥正在努力修复中..."),
    PARAM_NOT_VALID("OSS-10001", "参数错误"),
    ;


    // 异常码
    private final String errorCode;
    // 错误信息
    private final String errorMessage;
}
