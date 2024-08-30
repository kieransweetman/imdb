package fr.diginamic.imdb.service;

import fr.diginamic.imdb.dto.RealisateurDto;
import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.entity.Realisateur;
import fr.diginamic.imdb.repository.RealisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RealisateurService extends AbstractService<Realisateur, Integer> {

    @Autowired
    private RealisateurRepository realisateurRepository;

    @Autowired
    LieuService lieuService;

    @Override
    protected JpaRepository<Realisateur, Integer> getRepository() {
        return realisateurRepository;
    }

    public Realisateur updateNonNullFields(Realisateur existingRealisateur, RealisateurDto updatedRealisateurDto) {
        if (updatedRealisateurDto.getIdentite() != null) {
            existingRealisateur.setIdentite(updatedRealisateurDto.getIdentite());
        }

        if (updatedRealisateurDto.getUrl() != null) {
            existingRealisateur.setUrl(updatedRealisateurDto.getUrl());
        }

        return realisateurRepository.save(existingRealisateur);
    }
}
