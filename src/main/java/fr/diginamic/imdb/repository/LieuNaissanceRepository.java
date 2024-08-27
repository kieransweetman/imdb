package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.entity.LieuNaissanceId;

public interface LieuNaissanceRepository extends JpaRepository<LieuNaissance, LieuNaissanceId > {

}