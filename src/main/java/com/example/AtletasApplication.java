package com.example;

import com.example.service.AtletaService;
import com.example.service.MedallaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AtletasApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AtletasApplication.class, args);
		AtletaService atletaService = context.getBean(AtletaService.class);
		MedallaService medallaService = context.getBean(MedallaService.class);

		atletaService.testAtletas();
		medallaService.testMedallas();

	}
}
