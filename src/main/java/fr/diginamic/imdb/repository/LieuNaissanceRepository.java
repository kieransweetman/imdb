package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.entity.Realisateur;

@Repository
public interface LieuNaissanceRepository extends JpaRepository<LieuNaissance, Integer> {
    LieuNaissance findByRealisateurAndLieu(Realisateur r, Lieu l);
}