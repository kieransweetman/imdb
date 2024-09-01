package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.CastingPrincipal;
import fr.diginamic.imdb.repository.CastingPrincipalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CastingPrincipalService extends AbstractService<CastingPrincipal, Integer> {

    @Autowired
    private CastingPrincipalRepository castingPrincipal;

    @Override
    protected JpaRepository<CastingPrincipal, Integer> getRepository() {
        return castingPrincipal;
    }

    public CastingPrincipal findByActeurIdAndFilmId(Integer acteurId, Integer filmId) {
        return castingPrincipal.findByActeurIdAndFilmId(acteurId, filmId);
    }

}