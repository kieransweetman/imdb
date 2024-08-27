package fr.diginamic.imdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.imdb.utils.ImdbCsvParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ImdbApplication implements CommandLineRunner {

	@Autowired
	private ImdbCsvParser imdbCsvParser;

	public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// List of CSV file paths to parse
		List<String> csvFilePaths = Arrays.asList(
				"src/main/resources/data/acteurs.csv",
				"src/main/resources/data/castingPrincipal.csv",
				"src/main/resources/data/films.csv",
				"src/main/resources/data/pays.csv",
				"src/main/resources/data/film_realisateurs.csv",
				"src/main/resources/data/realisateurs.csv",
				"src/main/resources/data/roles.csv");

		imdbCsvParser.parseFiles(csvFilePaths);
	}

}
