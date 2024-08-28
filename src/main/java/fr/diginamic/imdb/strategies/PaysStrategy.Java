package fr.diginamic.imdb.strategies;

import org.springframework.beans.factory.annotation.Autowired;

import fr.diginamic.imdb.entity.Pays;
import fr.diginamic.imdb.service.PaysService;

public class PaysStrategy implements ICsvProcessingStrategy {

    @Autowired
    public PaysService paysService;

    @Override
    public void process(String line) {
        String[] fields = line.split(",");
        Pays pays = new Pays(fields[0], fields[1]);
        paysService.save(pays);
    }

}
