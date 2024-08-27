package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.CastingPrincipal;

@Repository
public interface CastingPrincipalRepository extends JpaRepository<CastingPrincipal, Integer>{

}
