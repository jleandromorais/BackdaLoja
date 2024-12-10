package com.trabalhadors.trabalhadores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication(scanBasePackages = "com.trabalhadors.trabalhadores")

public class TrabalhadoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrabalhadoresApplication.class, args);
	}

}
