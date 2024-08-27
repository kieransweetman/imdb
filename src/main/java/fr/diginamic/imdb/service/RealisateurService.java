package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Realisateur;
import fr.diginamic.imdb.repository.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealisateurService extends AbstractService<Realisateur, Integer> {

    @Autowired
    private RealisateurRepository realisateurRepository;

    @Override
    protected RealisateurRepository getRepository() {
        return realisateurRepository;
    }
}
