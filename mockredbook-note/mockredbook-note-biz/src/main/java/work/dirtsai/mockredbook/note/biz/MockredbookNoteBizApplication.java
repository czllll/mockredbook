package work.dirtsai.mockredbook.note.biz;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("work.dirtsai.mockredbook.note.biz.domain.mapper")
public class MockredbookNoteBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(MockredbookNoteBizApplication.class, args);
    }
}
