package fr.diginamic.imdb.strategies;

public interface CsvProcessingStrategy {
    void process(String[] line);
}