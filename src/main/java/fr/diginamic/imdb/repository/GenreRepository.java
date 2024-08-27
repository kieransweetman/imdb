package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.imdb.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Integer>{

}
