package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.imdb.entity.Pays;

public interface PaysRepository extends JpaRepository<Pays,Integer> {

	
}
