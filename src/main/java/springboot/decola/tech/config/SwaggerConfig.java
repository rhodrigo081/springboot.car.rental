package springboot.decola.tech.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Vehicle Allocation API")
                        .version("1.0.0")
                        .description("This API provides functionalities for managing a vehicle rental system, " +
                                "allowing the creation, listing, searching, and deletion of records for users, " +
                                "branches, vehicles, vehicle types, and rental proofs (VLNDocument)."));
    }
}