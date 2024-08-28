package fr.diginamic.imdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Tourner;

@Repository
public interface TournerRepository extends JpaRepository<Tourner, Integer>{

}