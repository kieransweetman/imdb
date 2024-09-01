package fr.diginamic.imdb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

  Optional<Role> findByFilmIdAndActeurId(Integer filmId, Integer acteurId);

  List<Role> findByFilm(Film film);

  List<Role> findByFilmId(Integer id);
}
