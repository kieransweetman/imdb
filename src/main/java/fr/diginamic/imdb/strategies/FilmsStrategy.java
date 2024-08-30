package fr.diginamic.imdb.strategies;

import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.entity.Genre;
import fr.diginamic.imdb.entity.Langue;
import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.entity.Pays;
import fr.diginamic.imdb.entity.Tourner;
import fr.diginamic.imdb.service.FilmService;
import fr.diginamic.imdb.service.GenreService;
import fr.diginamic.imdb.service.LieuService;
import fr.diginamic.imdb.service.PaysService;
import fr.diginamic.imdb.service.TournerService;

import java.time.Year;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmsStrategy implements ICsvProcessingStrategy {

    @Autowired
    private FilmService filmService;

    @Autowired
    private GenreService genreService;

    @Autowired
    private PaysService paysService;

    @Autowired
    private TournerService tournerService;

    @Autowired
    private LieuService lieuService;

    @Override
    public void process(String line, int lineIndex) {
        // ID IMDB;NOM;ANNEE;RATING;URL;LIEU TOURNAGE;GENRES;LANGUE;RESUME;PAYS;

        String[] fields = line.split(";");

        Film film = new Film();

        String idImdb = fields[0];
        if (idImdb != "" && !idImdb.isEmpty()) {
            film.setImdbId(idImdb);
        }

        String nom = fields[1];
        film.setNom(nom.trim());

        String annee = fields[2];
        film.setAnnee(Year.parse(annee.trim()));

        String resume = fields[8];
        film.setResume(resume.trim());

        String langueString = fields[7];
        Langue langue = new Langue();
        if (langueString != "" && !langueString.isEmpty()) {
            langue.setValue(langueString.toString());

        }
        film.setLangue(langue);

        String genres = fields[6];
        if (genres != null && !genres.isEmpty()) {
            String[] genresArray = genres.split(",");
            Genre g = new Genre();
            for (String genre : genresArray) {
                if (genreService.findByNom(genre) == null) {
                    g.setNom(genre);
                    genreService.save(g);
                } else {
                    g = genreService.findByNom(genre);
                }

                film.addGenre(g);

            }
        }

        String rating = fields[3];
        if (rating != null && !rating.isEmpty()) {
            try {
                float r = Float.parseFloat(rating.replace(",", ".").trim());
                film.setRating(r);
            } catch (NumberFormatException e) {
                // Handle the exception, e.g., log an error or set a default value
                System.err.println("Invalid rating format: " + rating);
                film.setRating(0.0f); // Default value
            }
        }

        String url = fields[4];
        if (url != null && !url.isEmpty()) {
            film.setUrl(url);
        }

        String paysString = fields[9];
        Pays pays;
        if (paysString != null && !paysString.isEmpty()) {
            Pays existingPays = paysService.findByNom(paysString);
            if (existingPays == null) {
                pays = new Pays();
                pays.setNom(paysString);
                pays = paysService.save(pays);

            } else {
                pays = paysService.findByNom(paysString);
            }

            film.setPays(pays);
        }

        // persist film before adding `tourner` location
        film = filmService.save(film);

        String lieuTournage = fields[5];
        String[] locationParts;
        Tourner tourner = new Tourner();
        Lieu lieu = new Lieu();
        if (lieuTournage != null && !lieuTournage.isEmpty()) {

            locationParts = lieuTournage.split(",");
            // country is always at the end
            // TODO -> if the lieu is an abbreviation (only two i counted? US and Uk), need
            // TODO -> also need to extract things that are like the following:
            // Montreuil, Seine [now Seine-Saint-Denis], France
            String countryString = locationParts[0].trim();

            if (countryString.equals("USA")) {
                countryString = "United States";
            } else if (countryString.equals("UK")) {
                countryString = "United Kingdom";
            }

            // anything that comes before the country is the name of the location
            String name = String.join(", ", Arrays.copyOfRange(locationParts, 1, locationParts.length));

            lieu = lieuService.findByNom(name);
            if (lieu == null) {
                lieu = new Lieu();
                lieu.setNom(name);
                lieu.setPays(film.getPays());
                lieu = lieuService.save(lieu);
            }

            tourner = new Tourner();
            tourner.setFilm(film);
            tourner.setLieu(lieu);

            tournerService.save(tourner);
        }

    }

}
