package com.gapsi.articleback.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

@Configuration
public class SwaggerConfig {

    Info apiInfo() {
        return new Info().title("Articles").description("Articles")
                .termsOfService("").version("1.0")
                .contact(new Contact().name("Articles").email("the.hector2603@gmail.com"));
    }


    @Bean
    public OpenAPI configureOpenApi() {
        return new OpenAPI()
                .info(apiInfo());
    }

}
