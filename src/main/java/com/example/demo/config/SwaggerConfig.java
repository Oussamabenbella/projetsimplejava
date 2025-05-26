package com.example.demo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public OpenAPI travelDestinationsAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Destinations de Voyage")
                        .description("API RESTful pour gérer des destinations de voyage")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Équipe de développement")
                                .url("https://github.com/Oussamabenbella/projetsimplejava")
                                .email("contact@example.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0.html")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentation supplémentaire")
                        .url("https://github.com/Oussamabenbella/projetsimplejava"))
                .servers(List.of(
                        new Server().url("https://projetsimplejava.onrender.com").description("Serveur de production"),
                        new Server().url("http://localhost:8080").description("Serveur de développement")
                ));
    }
}
