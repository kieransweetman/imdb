package fr.diginamic.imdb.strategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.diginamic.imdb.entity.Acteur;
import fr.diginamic.imdb.entity.CastingPrincipal;
import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.service.ActeurService;
import fr.diginamic.imdb.service.CastingPrincipalService;
import fr.diginamic.imdb.service.FilmService;

@Component
public class CastingPrincipalStrategy implements ICsvProcessingStrategy {

    @Autowired
    private FilmService filmService;

    @Autowired
    private ActeurService acteurService;

    @Autowired
    private CastingPrincipalService castingPrincipalService;

    @Override
    public void process(String line, int lineIndex) {

        // FILM;ID ACTEUR;
        String[] fields = line.split(";");
        String filmImdbString = fields[0];
        String acteurImdbString = fields[1];

        CastingPrincipal castingPrincipal = new CastingPrincipal();

        if (acteurImdbString != null && !acteurImdbString.isEmpty()) {
            Acteur a = acteurService.findByImdbId(acteurImdbString);

            if (a != null) {
                castingPrincipal.setActeur(a);
            }
        }

        if (filmImdbString != null && !filmImdbString.isEmpty()) {

            Film f = filmService.findByImdbId(filmImdbString);
            if (f != null) {
                castingPrincipal.setFilm(f);
            }
        }

        if (castingPrincipal.getActeur() != null && castingPrincipal.getFilm() != null) {
            castingPrincipalService.save(castingPrincipal);
        }
    }

}
