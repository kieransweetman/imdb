package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.CastingPrincipal;
import fr.diginamic.imdb.entity.CastingPrincipalId;
import fr.diginamic.imdb.repository.CastingPrincipalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CastingPrincipalService extends AbstractService<CastingPrincipal, CastingPrincipalId> {

    @Autowired
    private CastingPrincipalRepository castingPrincipal;

    @Override
    protected JpaRepository<CastingPrincipal, CastingPrincipalId> getRepository() {
        return castingPrincipal;
    }
}