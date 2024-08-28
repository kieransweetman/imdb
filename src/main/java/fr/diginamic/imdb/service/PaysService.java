package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Pays;
import fr.diginamic.imdb.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PaysService extends AbstractService<Pays, Integer> {

    @Autowired
    private PaysRepository paysRepository;

    @Override
    protected JpaRepository<Pays, Integer> getRepository() {
        return paysRepository;
    }

    public Pays findByNom(String nom) {
        return paysRepository.findByNom(nom);
    }
}
