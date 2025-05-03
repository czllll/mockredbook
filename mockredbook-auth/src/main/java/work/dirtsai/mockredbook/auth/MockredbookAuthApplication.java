package work.dirtsai.mockredbook.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "work.dirtsai.mockredbook")
public class    MockredbookAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockredbookAuthApplication.class, args);
    }

}
