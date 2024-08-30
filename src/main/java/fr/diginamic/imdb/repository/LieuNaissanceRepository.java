package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.LieuNaissance;

@Repository
public interface LieuNaissanceRepository extends JpaRepository<LieuNaissance, Integer> {

}