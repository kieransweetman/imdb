package fr.diginamic.imdb.strategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.diginamic.imdb.entity.Pays;
import fr.diginamic.imdb.service.PaysService;

@Component
public class PaysStrategy implements ICsvProcessingStrategy {

    private final PaysService paysService;

    @Autowired
    public PaysStrategy(PaysService paysService) {
        this.paysService = paysService;
    }

    @Override
    public void process(String line) {
        String[] fields = line.split(";");

        Pays existingPays = paysService.findByNom(fields[0]);
        if (existingPays != null) {
            System.out.println("skipping: " + existingPays.getNom());
            return;
        }

        Pays pays = new Pays();
        pays.setNom(fields[0]);
        pays.setUrl(fields[1]);
        paysService.save(pays);
    }
}
