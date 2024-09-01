package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Genre findByNom(String nom);
}
