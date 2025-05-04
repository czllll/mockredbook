package work.dirtsai.algocove.note.biz;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("work.dirtsai.algocove.note.biz.domain.mapper")
@EnableFeignClients(basePackages = "work.dirtsai.algocove")

public class AlgocoveNoteBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlgocoveNoteBizApplication.class, args);
    }
}
