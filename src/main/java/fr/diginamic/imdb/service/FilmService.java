package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmService extends AbstractService<Film, Integer> {

    @Autowired
    private FilmRepository filmRepository;

    @Override
    protected JpaRepository<Film, Integer> getRepository() {
        return filmRepository;
    }
}
