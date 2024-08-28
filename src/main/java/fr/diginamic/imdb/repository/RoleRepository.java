package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Role;
import fr.diginamic.imdb.entity.RoleId;

@Repository
public interface RoleRepository extends JpaRepository<Role, RoleId> {

}
