package work.dirtsai.mockredbook.user.relation.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("work.dirtsai.mockredbook")
@MapperScan("work.dirtsai.mockredbook.user.relation.biz.domain.mapper")
public class MockredbookUserRelationBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(MockredbookUserRelationBizApplication.class, args);
    }
}
