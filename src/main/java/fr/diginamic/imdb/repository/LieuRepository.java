package fr.diginamic.imdb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.entity.Pays;

@Repository
public interface LieuRepository extends JpaRepository<Lieu, Integer> {

    Lieu findByNom(String nom);

    List<Lieu> findByPays(Pays pays);

    Lieu findByNomAndPaysNom(String nom, String paysNom);

}
