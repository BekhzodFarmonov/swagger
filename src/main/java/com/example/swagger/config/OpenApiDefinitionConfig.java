package com.example.swagger.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
@Configuration
public class OpenApiDefinitionConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info().title("MY API").version("1.0.0"));
    }
    @Bean
    public OpenApiCustomizer openApiCustomiser() {
        return openApi -> openApi.addServersItem(new io.swagger.v3.oas.models.servers.
                Server().url("http://localhost:8080"));
    }
}