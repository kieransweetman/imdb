package fr.diginamic.imdb.strategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.diginamic.imdb.entity.Acteur;
import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.entity.Role;
import fr.diginamic.imdb.service.ActeurService;
import fr.diginamic.imdb.service.FilmService;
import fr.diginamic.imdb.service.RoleService;

@Component
public class RoleStrategy implements ICsvProcessingStrategy {

    @Autowired
    private FilmService filmService;

    @Autowired
    private ActeurService acteurService;

    @Autowired
    private RoleService roleService;

    @Override
    public void process(String line, int lineIndex) {
        // FILM;ID ACTEUR;PERSONNAGE;

        String[] fields = line.split(";");
        String filmImdbString = fields[0];
        String acteurImdbString = fields[1];
        String personnage = fields[2];

        Role role = new Role();

        if (personnage == null || personnage.isEmpty()) {
            personnage = "N/A";
        }

        role.setPersonnage(personnage);

        if (acteurImdbString != null && !acteurImdbString.isEmpty()) {
            Acteur a = acteurService.findByImdbId(acteurImdbString);

            if (a != null) {
                role.setActeur(a);
            }
        }

        if (filmImdbString != null && !filmImdbString.isEmpty()) {

            Film f = filmService.findByImdbId(filmImdbString);
            if (f != null) {
                role.setFilm(f);
            }
        }

        roleService.save(role);

    }

}
