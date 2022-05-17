package com.itau.casepix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class CasepixApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasepixApplication.class, args);
	}

}
