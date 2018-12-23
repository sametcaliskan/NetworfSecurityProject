package com.networkSecurity.NetworkSecurity1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;





@SpringBootApplication
public class NetworkSecurity1Application {
	private static final Logger logger = LoggerFactory.getLogger(NetworkSecurity1Application.class);
	public static void main(String[] args) {
		SpringApplication.run(NetworkSecurity1Application.class, args);
	}
	@Bean
	public CommandLineRunner setup() {
		return (args) -> {
			
			logger.info("The sample event data has been generated");
		};
	}

}

