package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PreDestroy;

@SpringBootApplication
@RestController
public class BootApplication {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@PreDestroy
	public void preDestroy(){
		logger.info("Goodbye!");
	}

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}
