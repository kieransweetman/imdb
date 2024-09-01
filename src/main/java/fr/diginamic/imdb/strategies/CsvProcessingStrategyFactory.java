package fr.diginamic.imdb.strategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * factory that will return the correct strategy
 */
@Component
public class CsvProcessingStrategyFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public ICsvProcessingStrategy getStrategyForFile(String csvFilePath) {
        if (csvFilePath.contains("films")) {
            return applicationContext.getBean(FilmsStrategy.class);
        } else if (csvFilePath.contains("acteurs")) {
            return applicationContext.getBean(ActeurStrategy.class);
        } else if (csvFilePath.contains("roles")) {
            return applicationContext.getBean(RoleStrategy.class);
        } else if (csvFilePath.contains("pays")) {
            return applicationContext.getBean(PaysStrategy.class);
        } else if (csvFilePath.contains("realisateurs")) {
            return applicationContext.getBean(RealisateurStrategy.class);
        } else if (csvFilePath.contains("castingPrincipal")) {
            return applicationContext.getBean(CastingPrincipalStrategy.class);
        } else {
            throw new IllegalArgumentException("No strategy found for file: " + csvFilePath);
        }
    }
}
