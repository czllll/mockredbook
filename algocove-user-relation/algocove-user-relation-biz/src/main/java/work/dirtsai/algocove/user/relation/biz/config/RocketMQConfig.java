package work.dirtsai.algocove.user.relation.biz.config;

import com.google.common.util.concurrent.RateLimiter;
import org.apache.rocketmq.spring.autoconfigure.RocketMQAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RocketMQAutoConfiguration.class)
public class RocketMQConfig {

}