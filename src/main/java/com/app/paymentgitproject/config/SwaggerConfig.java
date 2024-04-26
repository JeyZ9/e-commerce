package com.app.paymentgitproject.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
            description = "API documentation for MyProject E-commerce Web Application",
            title = "My Project E-commerce Web Application API",
            contact = @Contact(name = "Jeyer",
                                email = "jeyer@gmail.com"),
            version = "1.0",
            license = @License(name = "Jeyer"),
            termsOfService = "Terms of Service"
        ),
        security = {
                @io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "Bearer Authentication", scopes = {"global"}),
        }
)

@io.swagger.v3.oas.annotations.security.SecurityScheme(
        name = "Bearer Authentication",
        description = "JWT Authentication",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        in = SecuritySchemeIn.HEADER
)
public class SwaggerConfig {
}
