package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Acteur;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Integer> {

}
