package com.chitas.carderio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CarderioApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarderioApplication.class, args);
	}

}
