package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Realisateur;
import fr.diginamic.imdb.repository.RealisateurRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RealisateurService extends AbstractService<Realisateur, Integer> {

    @Autowired
    private RealisateurRepository realisateurRepository;

    @Override
    protected JpaRepository<Realisateur, Integer> getRepository() {
        return realisateurRepository;
    }
}
