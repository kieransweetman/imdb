package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Integer>{
    public interface FilmRepository extends JpaRepository<Film, Integer> {

        // Trouver un film par son ID
        Optional<Film> findById(Integer id);
    
        // Trouver tous les films (optionnel, si nécessaire)
        List<Film> findAll();
    
        // Trouver les films avec un rôle spécifique (optionnel, si vous souhaitez faire cette recherche)
        @Query("SELECT f FROM Film f JOIN f.roles r WHERE r.personnage = :personnage")
        List<Film> findFilmsByRoleCharacterName(@Param("personnage") String personnage);
    }

}
