package work.dirtsai.algocove.feed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author czl$
 * @date 2025/5/4$
 */

@SpringBootApplication
@EnableFeignClients(basePackages = "work.dirtsai.algocove")
public class AlgocoveFeedApplication {
    public static void main(String[] args) {
        SpringApplication.run(work.dirtsai.algocove.feed.AlgocoveFeedApplication.class, args);
    }
}
