package work.dirtsai.mockredbook.comment.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@MapperScan("work.dirtsai.mockredbook.comment.biz.domain.mapper")
@EnableRetry
@EnableFeignClients(basePackages = "work.dirtsai.mockredbook")
public class MockredbookCommentBizApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockredbookCommentBizApplication.class, args);
    }

}
