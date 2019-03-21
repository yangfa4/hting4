package com.sy.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;


@ImportResource(value = {"classpath:spring-web.xml"})
@SpringBootApplication
public class Hanting4Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Hanting4Application.class, args);
		
		
	}
	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Hanting4Application.class);
	}
}
