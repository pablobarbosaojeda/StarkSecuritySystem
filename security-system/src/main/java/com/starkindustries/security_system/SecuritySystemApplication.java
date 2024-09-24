package com.starkindustries.security_system;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SecuritySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritySystemApplication.class, args);
	}
}
