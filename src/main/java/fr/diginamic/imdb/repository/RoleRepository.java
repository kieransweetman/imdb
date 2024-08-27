package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.diginamic.imdb.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
