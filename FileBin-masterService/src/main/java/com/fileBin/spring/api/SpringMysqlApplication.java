package com.fileBin.spring.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.fileBin.spring.api.repository")
@SpringBootApplication
public class SpringMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlApplication.class, args);
	}
}
