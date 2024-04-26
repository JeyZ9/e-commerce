package com.app.paymentgitproject;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "LuxSmartBuy E-commerce App REST APIs",
				description = "LuxSmartBuy E-commerce App REST APIs Documentation",
				version = "v1.0",
				contact = @Contact(
						name = "Charisplace",
						email = "greatcharis26@gmail.com",
						url = "https://github.com/Realwale"
				),
				license = @License(
						name = "Apache 2.8",
						url = "https://github.com/Realwale/license"

				)
		),
		externalDocs = @ExternalDocumentation(
				description = "LuxSmartBuy E-commerce App REST APIs Documentation"
		)
)
public class PaymentGitProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentGitProjectApplication.class, args);
	}

}
