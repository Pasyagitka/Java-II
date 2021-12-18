package meow.pasyagitka.findtrainingvideos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class FindTrainingVideosApplication {

    public static void main(String[] args) {
        SpringApplication.run(FindTrainingVideosApplication.class, args);
    }

}
