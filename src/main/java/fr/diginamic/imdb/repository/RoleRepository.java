package fr.diginamic.imdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.entity.Role;
import fr.diginamic.imdb.entity.RoleId;

@Repository
public interface RoleRepository extends JpaRepository<Role, RoleId> {
  // Trouver les rôles par film
    List<Role> findByFilmId(Long filmId);
}

