package com.kardex.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
public class ApiKardesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiKardesApplication.class, args);
	}

}
