package me.silvernine.tutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class JwtTutorialApplication {
	public static void main(String[] args) {
		log.info("Funciona log4j en jwt-tutorial");
		SpringApplication.run(JwtTutorialApplication.class, args);
	}
}
