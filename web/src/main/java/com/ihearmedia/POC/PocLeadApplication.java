package com.ihearmedia.POC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.iheartmeadia.POC.controller.LeadControlller;

@SpringBootApplication
@ComponentScan(basePackageClasses = {LeadControlller.class},basePackages = "com.iheartmeadia.POC.model,com.iheartmeadia.POC.services" )
@EnableJpaRepositories(basePackages={"com.iheartmeadia.POC.*"})
@EnableAutoConfiguration
@EntityScan(basePackages={"com.iheartmeadia.POC.model"})
public class PocLeadApplication {

	public static void main(String[] args) {
		SpringApplication.run(PocLeadApplication.class, args);
	}
}
