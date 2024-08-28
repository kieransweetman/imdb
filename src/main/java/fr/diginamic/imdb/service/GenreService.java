package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Genre;
import fr.diginamic.imdb.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService extends AbstractService<Genre, Integer> {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    protected JpaRepository<Genre, Integer> getRepository() {
        return genreRepository;
    }
}
