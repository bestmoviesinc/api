package com.bestmovies.bestmoviesinc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BestmoviesincApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestmoviesincApplication.class, args);
	}

}
