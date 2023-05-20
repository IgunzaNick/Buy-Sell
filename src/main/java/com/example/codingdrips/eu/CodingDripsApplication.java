package com.example.codingdrips.eu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.codingdrips.controller","com.example.codingdrips.model","com.example.codingdrips.repository","com.example.codingdrips.service","com.example.codingdrips.configuaration" })
@EnableJpaRepositories("com.example.codingdrips.repository")
@EntityScan("com.example.codingdrips.model")

public class CodingDripsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodingDripsApplication.class, args);
	}
	


}
