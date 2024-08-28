// package fr.diginamic.imdb.utils;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;
// import org.springframework.beans.factory.annotation.Autowired;

// import java.util.Arrays;
// import java.util.List;

// @Component
// public class CsvFileRunner implements CommandLineRunner {

// @Autowired
// private ImdbCsvParser imdbCsvParser;

// @Override
// public void run(String... args) throws Exception {
// // List of CSV file paths to parse
// List<String> csvFilePaths = Arrays.asList(
// "src/main/resources/data/acteurs.csv",
// "src/main/resources/data/castingPrincipal.csv",
// "src/main/resources/data/films.csv",
// "src/main/resources/data/pays.csv",
// "src/main/resources/data/film_realisateurs.csv",
// "src/main/resources/data/realisateurs.csv",
// "src/main/resources/data/roles.csv");

// imdbCsvParser.parseFiles(csvFilePaths);
// System.out.println("Finished processing all files.");
// }
// }