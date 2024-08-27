package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Tourner;
import fr.diginamic.imdb.repository.TournerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournerService extends AbstractService<Tourner, Long> {

    @Autowired
    private TournerRepository tournerRepository;

    @Override
    protected TournerRepository getRepository() {
        return tournerRepository;
    }
}
