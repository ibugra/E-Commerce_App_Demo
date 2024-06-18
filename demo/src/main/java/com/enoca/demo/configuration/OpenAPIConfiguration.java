package com.enoca.demo.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI().info(new Info().title("ENOCA JAVA Challenge")
                        .description("E-Commerce App Demo Project").version("v0.1"));
    }

    @Bean
    public GroupedOpenApi cartApi() {
        return GroupedOpenApi.builder().group("cart").pathsToMatch("/cart/**").build();
    }

    @Bean
    public GroupedOpenApi customerApi() {
        return GroupedOpenApi.builder().group("customer").pathsToMatch("/customer/**").build();
    }

    @Bean
    public GroupedOpenApi orderApi() {
        return GroupedOpenApi.builder().group("order").pathsToMatch("/order/**").build();
    }

    @Bean
    public GroupedOpenApi productApi() {
        return GroupedOpenApi.builder().group("product").pathsToMatch("/product/**").build();
    }

}
