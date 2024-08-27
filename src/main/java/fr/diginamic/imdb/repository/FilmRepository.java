package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.imdb.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Integer>{

}
