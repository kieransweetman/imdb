package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.imdb.entity.Acteur;

public interface ActeurRepository extends JpaRepository<Acteur, Integer> {

}
