package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.imdb.entity.Lieu;

public interface LieuRepository extends JpaRepository<Lieu, Integer> {

}
