package fr.diginamic.imdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Acteur;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Integer> {

    Acteur findByImdbId(String imdbId);

    Optional<Acteur> findById(Integer id);
}
