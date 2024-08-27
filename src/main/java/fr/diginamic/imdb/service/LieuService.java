package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.repository.LieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LieuService extends AbstractService<Lieu, Integer> {

    @Autowired
    private LieuRepository lieuRepository;

    @Override
    protected LieuRepository getRepository() {
        return lieuRepository;
    }
}
