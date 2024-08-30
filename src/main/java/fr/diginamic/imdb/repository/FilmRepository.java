package fr.diginamic.imdb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer> {
    
    Film findByNom(String nom);
}



