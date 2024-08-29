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

        Pays existingPays = paysService.findByNom(fields[0]);

        if (existingPays != null)
            return;

        Pays pays = new Pays();
        pays.setNom(fields[0]);
        pays.setUrl(fields[1]);
        paysService.save(pays);
    }
}
