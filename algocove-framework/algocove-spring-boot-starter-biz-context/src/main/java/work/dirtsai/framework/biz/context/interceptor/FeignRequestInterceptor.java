package work.dirtsai.framework.biz.context.interceptor;


import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import work.dirtsai.framework.biz.context.holder.LoginUserContextHolder;
import work.dirtsai.framework.common.constant.GlobalConstants;

import java.util.Objects;

/**
 * feign请求拦截器
 */
@Slf4j
public class FeignRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        // 获取当前上下文中的用户 ID
        Long userId = LoginUserContextHolder.getUserId();

        // 若不为空，则添加到请求头中
        if (Objects.nonNull(userId)) {
            requestTemplate.header(GlobalConstants.USER_ID, String.valueOf(userId));
            log.info("########## feign 请求设置请求头 userId: {}", userId);
        }
    }
}
