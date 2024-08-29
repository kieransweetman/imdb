package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.repository.LieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LieuService extends AbstractService<Lieu, Integer> {

    @Autowired
    private LieuRepository lieuRepository;

    @Override
    protected JpaRepository<Lieu, Integer> getRepository() {
        return lieuRepository;
    }
    
    
    public Lieu findByNom(String nom) {
    	return lieuRepository.findByNom(nom);
    }
}
