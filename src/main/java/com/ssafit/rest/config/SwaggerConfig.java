package com.ssafit.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI().info(info());
	}

	private Info info() {
		return new Info().title("SSAFIT REST API").description("SSAFIT").version("v.0.0.1")
				.license(new License().name("Apache 2.0").url("http://springdoc.org"));
	}
}
