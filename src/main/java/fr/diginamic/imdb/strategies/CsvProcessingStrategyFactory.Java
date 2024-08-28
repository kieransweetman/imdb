package fr.diginamic.imdb.strategies;

/**
 * factory that will return the correct strategy
 */
public class CsvProcessingStrategyFactory {
    public static ICsvProcessingStrategy getStrategyForFile(String csvFilePath) {
        if (csvFilePath.contains("films")) {
            return new FilmsStrategy();
        } else if (csvFilePath.contains("acteurs")) {
            return new ActeurStrategy();
        } else if (csvFilePath.contains("roles")) {
            return new RoleStrategy();
        } else if (csvFilePath.contains("pays")) {
            return new PaysStrategy();
        } else if (csvFilePath.contains("realisateurs")) {
            return new RealisateurStrategy();
        } else if (csvFilePath.contains("castingPrincipal")) {
            return new CastingPrincipalStrategy();
        } else {
            return new FilmRealisateurStrategy();
        }
    }
}
