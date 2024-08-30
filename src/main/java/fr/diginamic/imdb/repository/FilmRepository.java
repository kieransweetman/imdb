package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    Film findByImdbId(String imdbId);
}
