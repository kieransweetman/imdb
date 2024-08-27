package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Pays;
import fr.diginamic.imdb.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaysService extends AbstractService<Pays, Long> {

    @Autowired
    private PaysRepository paysRepository;

    @Override
    protected PaysRepository getRepository() {
        return paysRepository;
    }
}
