package com.tasktracker.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI taskTrackerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Task Tracker API")
                        .description("RESTful API for managing tasks with CRUD operations")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Task Tracker Team")
                                .email("contact@tasktracker.com")));
    }
}