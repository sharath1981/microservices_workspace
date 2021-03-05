package com.kpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AdditionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdditionServiceApplication.class, args);
	}

}
