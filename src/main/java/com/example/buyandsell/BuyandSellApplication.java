package com.example.buyandsell;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.buyandsell.controller","com.example.buyandsell.dto","com.example.buyandsell.global","com.example.buyandsell.model","com.example.buyandsell.repository","com.example.buyandsell.service","com.example.buyandsell.configuaration"})
@EnableJpaRepositories("com.example.buyandsell.repository")
@EntityScan("com.example.buyandsell.model")

public class BuyandSellApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyandSellApplication.class, args);
	}

}
