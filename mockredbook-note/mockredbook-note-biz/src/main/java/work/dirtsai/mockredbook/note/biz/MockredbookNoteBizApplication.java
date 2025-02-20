package work.dirtsai.mockredbook.note.biz;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("work.dirtsai.mockredbook.note.biz.domain.mapper")
@EnableFeignClients(basePackages = "work.dirtsai.mockredbook")

public class MockredbookNoteBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(MockredbookNoteBizApplication.class, args);
    }
}
