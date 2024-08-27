package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Genre;
import fr.diginamic.imdb.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends AbstractService<Genre, Long> {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    protected GenreRepository getRepository() {
        return genreRepository;
    }
}
