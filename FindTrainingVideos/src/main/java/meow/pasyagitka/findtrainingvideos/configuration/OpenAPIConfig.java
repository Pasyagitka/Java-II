package meow.pasyagitka.findtrainingvideos.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI().info(new Info().title("Training Videos")
                        .contact(new Contact().name("pasyagitka")
                        .email("lizavetazinovich@gmail.com")))
                        .servers(List.of(new Server().url("http://localhost:8080")
                        .description("Dev service")));
    }
}
