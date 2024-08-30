package fr.diginamic.imdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.entity.Realisateur;
import fr.diginamic.imdb.repository.LieuNaissanceRepository;

@Service
public class LieuNaissanceService extends AbstractService<LieuNaissance, Integer> {

    @Autowired
    private LieuNaissanceRepository lieuNaissanceRepository;

    @Override
    protected JpaRepository<LieuNaissance, Integer> getRepository() {
        return lieuNaissanceRepository;
    }

    public LieuNaissance findByRealisateurAndLieu(Realisateur r, Lieu l) {
        return lieuNaissanceRepository.findByRealisateurAndLieu(r, l);
    }
}