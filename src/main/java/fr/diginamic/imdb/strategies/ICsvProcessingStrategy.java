package fr.diginamic.imdb.strategies;

public interface ICsvProcessingStrategy {
    void process(String line, int lineIndex) throws Exception;

}