package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Pays;

@Repository
public interface PaysRepository extends JpaRepository<Pays,Integer> {

	
}
