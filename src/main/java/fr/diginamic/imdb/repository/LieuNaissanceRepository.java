package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.entity.LieuNaissanceId;

@Repository
public interface LieuNaissanceRepository extends JpaRepository<LieuNaissance, LieuNaissanceId > {

}