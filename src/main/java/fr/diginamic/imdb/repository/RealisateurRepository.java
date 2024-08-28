package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Realisateur;

@Repository
public interface RealisateurRepository extends JpaRepository<Realisateur, Integer>{

}
