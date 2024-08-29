package fr.diginamic.imdb.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import fr.diginamic.imdb.strategies.ICsvProcessingStrategy;
import fr.diginamic.imdb.strategies.CsvProcessingStrategyFactory;

/**
 * This class is responsible for parsing the CSV files and delegating the
 * processing to the appropriate strategy.
 * 
 * We skip the head here and process each line of the CSV file inside the
 * specified strategy
 */
@Component
public class ImdbCsvParser {
    private final CsvProcessingStrategyFactory csvProcessingStrategyFactory;

    @Autowired
    public ImdbCsvParser(CsvProcessingStrategyFactory csvProcessingStrategyFactory) {
        this.csvProcessingStrategyFactory = csvProcessingStrategyFactory;
    }

    public void parseFiles(List<String> csvFilePaths) {

        for (String csvFilePath : csvFilePaths) {

            ICsvProcessingStrategy strategy = csvProcessingStrategyFactory.getStrategyForFile(csvFilePath);

            System.out.println("Processing file: " + csvFilePath);

            try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

                // skip headers
                br.readLine();

                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        strategy.process(line);
                    } catch (Exception e) {
                        ImdbException.log(e);
                    }

                }
            } catch (IOException e) {
                ImdbException.log(e);
            }
        }

    }

}