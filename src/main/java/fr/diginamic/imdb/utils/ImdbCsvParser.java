package fr.diginamic.imdb.utils;

import org.springframework.stereotype.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import fr.diginamic.imdb.strategies;

@Component
public class ImdbCsvParser {
    public void parseFiles(List<String> csvFilePaths) {
        for (String csvFilePath : csvFilePaths) {

            CsvProcessingStrategyFactory strategy = CsvProcessingStrategyFactory.getStrategyForFile(csvFilePath);
            if (strategy == null) {
                ImdbException.log(new IllegalArgumentException("No strategy found for file: " + csvFilePath));
                continue;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {

                // skip headers
                br.readLine();

                String line;
                while ((line = br.readLine()) != null) {
                    try {
                        strategy.processLine(line);
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