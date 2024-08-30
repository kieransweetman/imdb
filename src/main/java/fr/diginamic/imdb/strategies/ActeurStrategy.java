package fr.diginamic.imdb.strategies;

import java.time.Instant;
// import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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
    public void process(String line) {
        // IMDB;IDENTITE;DATE NAISSANCE;LIEU NAISSANCE;TAILLE;URL
        // nm0184429;Franklin Cover;November 20 1928 ;Cleveland, Ohio, USA ;1.93
        // m;/name/nm0184429/?ref_=tt_cl_t_3
        String[] fields = line.split(";");

        // Actor info
        String identite = fields[1];
        Float taille = Float
                .parseFloat(fields[4].trim() != "" ? fields[4].split(" ")[0].replaceAll("[^\\d.]", "") : "0");
        String url = fields[5];

        Acteur acteur = new Acteur(identite, taille, url);
        Acteur newActeur = acteurService.save(acteur);

        // Date and place of birth

        String[] locationParts = fields[3].split(",");
        // country is always at the end
        // TODO -> if the lieu is an abbreviation (only two i counted? US and Uk), need
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
        String name = String.join(", ", Arrays.copyOf(locationParts, locationParts.length - 1)).trim();
        // to map it to the correct full name.
        Lieu lieu = lieuService.findByNom(name);

        if (lieu == null) {
            lieu = new Lieu();
            lieu.setNom(name);
            lieu.setPays(pays);
            lieu = lieuService.save(lieu);
        }
        LieuNaissance ln = new LieuNaissance();
        String dateString = fields[2].trim();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d yyyy",
                Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateString, formatter);
        Instant instant = date.atStartOfDay(ZoneId.systemDefault()).toInstant();
        Date dob = Date.from(instant);
        System.out.println(dob.toString());
        // ln.setActeur(newActeur);
        // ln.setDate(dob);

        // lieuNaissanceService.save(ln);
    }

}
