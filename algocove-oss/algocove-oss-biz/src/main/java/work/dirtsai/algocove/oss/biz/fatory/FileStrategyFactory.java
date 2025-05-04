package work.dirtsai.algocove.oss.biz.fatory;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import work.dirtsai.algocove.oss.biz.strategy.FileStrategy;
import work.dirtsai.algocove.oss.biz.strategy.impl.AliyunOSSFileStrategy;
import work.dirtsai.algocove.oss.biz.strategy.impl.MinioFileStrategy;

@RefreshScope
@Configuration
public class FileStrategyFactory {

    @Value("${storage.type}")
    private String strategyType;

    @Bean
    @RefreshScope
    public FileStrategy getFileStrategy() {
        if (StringUtils.equals(strategyType, "minio")) {
            return new MinioFileStrategy();
        } else if (StringUtils.equals(strategyType, "aliyun")) {
            return new AliyunOSSFileStrategy();
        }

        throw new IllegalArgumentException("不可用的存储类型");
    }

}