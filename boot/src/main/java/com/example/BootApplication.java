package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BootApplication {

	@RequestMapping("/")
	public String hello(){
		return "Hello";
	}

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
}
