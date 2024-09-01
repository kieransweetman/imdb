package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.entity.Pays;
import fr.diginamic.imdb.repository.LieuRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LieuService extends AbstractService<Lieu, Integer> {

    @Autowired
    private LieuRepository lieuRepository;

    @Override
    protected JpaRepository<Lieu, Integer> getRepository() {
        return lieuRepository;
    }

    public Lieu findByNom(String nom) {
        return lieuRepository.findByNom(nom);
    }

    public List<Lieu> findByPays(Pays pays) {
        return lieuRepository.findByPays(pays);
    }

    public Lieu findByNomAndPaysNom(String name, String country) {
        return lieuRepository.findByNomAndPaysNom(name, country);
    }
}
