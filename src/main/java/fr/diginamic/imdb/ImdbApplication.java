package fr.diginamic.imdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "fr.diginamic.imdb")
public class ImdbApplication {
	public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}
}