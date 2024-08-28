package fr.diginamic.imdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.entity.LieuNaissanceId;
import fr.diginamic.imdb.repository.LieuNaissanceRepository;

@Service
public class LieuNaissanceService extends AbstractService<LieuNaissance, LieuNaissanceId > {

    @Autowired
    private LieuNaissanceRepository lieuNaissanceRepository;

    @Override
    protected JpaRepository<LieuNaissance, LieuNaissanceId > getRepository() {
        return lieuNaissanceRepository;
    }
}