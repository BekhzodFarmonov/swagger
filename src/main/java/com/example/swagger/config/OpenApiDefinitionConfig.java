package com.example.swagger.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
                Server().url("http://localhost:8080"))
                .addSecurityItem(new SecurityRequirement().addList("basicAuth"))
                .components((new Components()
                        .addSecuritySchemes("basicAuth",new SecurityScheme()
                                .name("basicAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic"))))
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth",new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}