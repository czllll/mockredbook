package work.dirtsai.algocove.comment.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@MapperScan("work.dirtsai.algocove.comment.biz.domain.mapper")
@EnableRetry
@EnableFeignClients(basePackages = "work.dirtsai.algocove")
public class AlgocoveCommentBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgocoveCommentBizApplication.class, args);
    }

}
