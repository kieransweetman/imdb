package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Acteur;
import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.repository.ActeurRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ActeurService extends AbstractService<Acteur,Integer>  {

    @Autowired
    private ActeurRepository acteurRepository;
    protected JpaRepository<Acteur,Integer> getRepository(){
        return acteurRepository;
    };
    

}