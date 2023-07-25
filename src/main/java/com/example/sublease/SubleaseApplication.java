package com.example.sublease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.example.sublease.sys.entity")
public class SubleaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubleaseApplication.class, args);
	}

}
