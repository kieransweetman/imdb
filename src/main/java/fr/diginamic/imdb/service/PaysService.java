package fr.diginamic.imdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.diginamic.imdb.entity.Pays;
import fr.diginamic.imdb.repository.PaysRepository;

@Service
public class PaysService extends AbstractService<Pays, Integer> {

    @Autowired
    private PaysRepository paysRepository;

    public Pays getByNom(String nom) {
        Pays pays = paysRepository.findByNom(nom);
        if (pays == null) {

            System.out.println("Pays introuvable");
        }
        return pays;
    }

    @Override
    protected JpaRepository<Pays, Integer> getRepository() {
        return paysRepository;
    }
}
