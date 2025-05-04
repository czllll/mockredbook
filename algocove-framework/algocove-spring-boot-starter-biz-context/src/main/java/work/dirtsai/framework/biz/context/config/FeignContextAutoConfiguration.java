package work.dirtsai.framework.biz.context.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import work.dirtsai.framework.biz.context.interceptor.FeignRequestInterceptor;

/**
 * feign请求拦截器自动配置
 */
@AutoConfiguration
public class FeignContextAutoConfiguration {

    @Bean
    public FeignRequestInterceptor feignRequestInterceptor() {
        return new FeignRequestInterceptor();
    }
}
