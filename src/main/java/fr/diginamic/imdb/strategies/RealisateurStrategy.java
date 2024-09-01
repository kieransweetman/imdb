package fr.diginamic.imdb.strategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.entity.Pays;
import fr.diginamic.imdb.entity.Realisateur;
import fr.diginamic.imdb.service.LieuNaissanceService;
import fr.diginamic.imdb.service.LieuService;
import fr.diginamic.imdb.service.PaysService;
import fr.diginamic.imdb.service.RealisateurService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;

@Component
public class RealisateurStrategy implements ICsvProcessingStrategy {

    @Autowired
    private RealisateurService realisateurService;

    @Autowired
    private LieuNaissanceService lieuNaissanceService;

    @Autowired
    private LieuService lieuService;

    @Autowired
    private PaysService paysService;

    @Override
    public void process(String line, int lineIndex) {
        // ID;IDENTITE;DATE NAISSANCE;LIEU NAISSANCE;URL;
        String[] fields = line.split(";");

        // Actor info
        String imdbString = fields[0];
        String identite = fields[1];
        String url = fields[4];

        Realisateur realisateur = new Realisateur(identite, url);
        realisateur.setImddId(imdbString);
        Realisateur newRealisateur = realisateurService.save(realisateur);

        LieuNaissance ln = new LieuNaissance();
        String dateString = fields[2];
        LocalDate date;
        if (dateString != null &&
                !dateString.isEmpty()) {
            dateString = dateString.trim();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy",
                    Locale.ENGLISH);
            date = LocalDate.parse(dateString, formatter);
            ln.setDate(date);

        }

        // Date and place of birth
        String[] locationParts;
        Lieu lieu = new Lieu();
        if (fields[3] != null || !fields[3].isEmpty()) {

            locationParts = fields[3].split(",");
            // country is always at the end
            // TODO -> if the lieu is an abbreviation (only two i counted? US and Uk), need
            // TODO -> also need to extract things that are like the following:
            // Montreuil, Seine [now Seine-Saint-Denis], France
            String countryString = locationParts[locationParts.length - 1].trim();

            if (countryString.equals("USA")) {
                countryString = "United States";
            } else if (countryString.equals("UK")) {
                countryString = "United Kingdom";
            }

            Pays pays = paysService.findByNom(countryString);

            if (pays == null) {
                pays = new Pays();
                pays.setNom(countryString);
                pays = paysService.save(pays);
            }

            // anything that comes before the country is the name of the location
            String name = String.join(", ", Arrays.copyOf(locationParts, locationParts.length - 1));

            lieu = lieuService.findByNom(name);
            if (lieu == null) {
                lieu = new Lieu();
                lieu.setNom(name);
                lieu.setPays(pays);
            }

        }

        lieu = lieuService.save(lieu);
        ln.setLieu(lieu);

        ln.setRealisateur(newRealisateur);
        // // Explicitly set realisateur to null if not applicable
        ln.setActeur(null);

        lieuNaissanceService.save(ln);
    }
}
