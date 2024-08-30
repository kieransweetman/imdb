package fr.diginamic.imdb.utils;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import fr.diginamic.imdb.repository.ActeurRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@Component
public class CsvFileRunner implements CommandLineRunner {

    @Autowired
    private ImdbCsvParser imdbCsvParser;

    @Autowired
    private ActeurRepository acteurRepository; // Inject the repository

    @Override
    public void run(String... args) throws Exception {

    }

    private boolean isDatabasePopulated() {
        return acteurRepository.count() > 0; // Check if the Acteur table has any entries
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() throws Exception {

        // if (isDatabasePopulated()) {
        // System.out.println("Database is already populated. Skipping CSV file
        // parsing.");
        // return;
        // }

        System.out.println("Starting csv parsing");

        // List of CSV file paths to parse
        List<String> csvFilePaths = Arrays.asList(
                "src/main/resources/data/pays.csv",
                "src/main/resources/data/acteurs.csv",
                "src/main/resources/data/realisateurs.csv",
                "src/main/resources/data/films.csv",
                "src/main/resources/data/castingPrincipal.csv",
                "src/main/resources/data/roles.csv");

        imdbCsvParser.parseFiles(csvFilePaths);
        System.out.println("Finished processing all files.");
    }

}