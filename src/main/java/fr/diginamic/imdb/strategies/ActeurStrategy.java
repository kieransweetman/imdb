package fr.diginamic.imdb.strategies;

// import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.diginamic.imdb.entity.Acteur;
import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.entity.Pays;
import fr.diginamic.imdb.service.ActeurService;
import fr.diginamic.imdb.service.LieuNaissanceService;
import fr.diginamic.imdb.service.LieuService;
import fr.diginamic.imdb.service.PaysService;
import fr.diginamic.imdb.utils.ImdbException;

@Component
public class ActeurStrategy implements ICsvProcessingStrategy {
    @Autowired
    private ActeurService acteurService;

    @Autowired
    private LieuNaissanceService lieuNaissanceService;

    @Autowired
    private LieuService lieuService;

    @Autowired
    private PaysService paysService;

    // @Autowired
    // public ActeurStrategy(ActeurService acteurService) {
    // this.acteurService = acteurService;
    // }

    @Override
    public void process(String line, int lineIndex) throws Exception {
        // IMDB;IDENTITE;DATE NAISSANCE;LIEU NAISSANCE;TAILLE;URL
        // nm0184429;Franklin Cover;November 20 1928 ;Cleveland, Ohio, USA ;1.93
        // m;/name/nm0184429/?ref_=tt_cl_t_3
        String[] fields = line.split(";");

        // Actor info
        String identite = fields[1];
        Float taille = null;
        if (fields[4] != null && !fields[4].isEmpty()) {
            try {
                taille = Float.parseFloat(fields[4].split(" ")[0].replaceAll("[^\\d.]", ""));
            } catch (NumberFormatException e) {
                // Handle the exception, e.g., log an error or set a default value
                ImdbException.log("Invalid float format for taille: " + fields[4]);
            }
        } else {
            ImdbException.log("line: " + lineIndex + " -> taille is null or empty: " + fields[4]);
        }

        String url = fields[5];
        Acteur acteur = new Acteur(identite, taille, url);
        Acteur newActeur = acteurService.save(acteur);
        String dateString = fields[2];

        LieuNaissance ln = new LieuNaissance();
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
                lieu = lieuService.save(lieu);
            }

        }
        ln.setLieu(lieu);

        ln.setActeur(newActeur);
        // // Explicitly set realisateur to null if not applicable
        ln.setRealisateur(null);

        lieuNaissanceService.save(ln);
    }

}
