package work.dirtsai.algocove.user.relation.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("work.dirtsai.algocove")
@MapperScan("work.dirtsai.algocove.user.relation.biz.domain.mapper")
public class AlgocoveUserRelationBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlgocoveUserRelationBizApplication.class, args);
    }
}
