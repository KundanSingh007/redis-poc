package com.redis.redispoc;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@EnableCaching
@SpringBootApplication
@OpenAPIDefinition(

		/*
		 * tags = {
		 * 
		 * @Tag(name="widget", description="Widget operations."),
		 * 
		 * @Tag(name="gasket", description="Operations related to CONSPROM") },
		 */

		info = @Info(title = "indigo-Redis-Api-2023", version = "2.0.1", contact = @Contact(name = "Api for CONSPROM", url = "http://indigo.com/contact", email = "indigo@indigo.com"), license = @License(name = "CSPM 2.0", url = "https://indigo/")))
public class RedispocApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RedispocApplication.class, args);
		System.out.println("Application Started");
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(RedispocApplication.class);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
