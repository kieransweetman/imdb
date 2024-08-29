package fr.diginamic.imdb.strategies;

import org.springframework.beans.factory.annotation.Autowired;

import fr.diginamic.imdb.entity.Acteur;
import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.service.ActeurService;
import fr.diginamic.imdb.service.LieuNaissanceService;
import fr.diginamic.imdb.service.LieuService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

import java.util.Arrays;

public class ActeurStrategy implements ICsvProcessingStrategy {

    @Autowired
    public ActeurService acteurService;

    @Autowired
    public LieuNaissanceService lieuNaissanceService;

    @Autowired
    public LieuService lieuService;

    @Override
    public void process(String line) {
        // IMDB;IDENTITE;DATE NAISSANCE;LIEU NAISSANCE;TAILLE;URL
        // nm0184429;Franklin Cover;November 20 1928 ;Cleveland, Ohio, USA ;1.93
        // m;/name/nm0184429/?ref_=tt_cl_t_3
        String[] fields = line.split(";");

        // Actor info
        String identite = fields[1];
        Float taille = Float.parseFloat(fields[4]);
        String url = fields[5];

        Acteur acteur = new Acteur(identite, taille, url);
        Acteur newActeur = acteurService.save(acteur);

        // Date and place of birth
        Lieu lieu = new Lieu();
        LieuNaissance ln = new LieuNaissance();

        String[] locationParts = fields[3].split(",");
        // country is always at the end
        // TODO -> if the lieu is an abbreviation (only two i counted? US and Uk), need
        String country = locationParts[locationParts.length - 1].trim();
        // anything that comes before the country is the name of the location
        String name = String.join(", ", Arrays.copyOf(locationParts, locationParts.length - 1)).trim();
        // to map it to the correct full name.

        Lieu existingLieu = lieuService.findByNomAndPaysNom(name, country);
        if (existingLieu != null) {
            ln.setLieu(existingLieu);
        } else {
            lieu.setNom(fields[3]);
            lieu = lieuService.save(lieu);
            ln.setLieu(lieu);
        }

        String dateString = fields[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(dateString, formatter);
        Date dob = Date.valueOf(date);

        ln.setActeur(newActeur);
        ln.setDate(dob);

        lieuNaissanceService.save(ln);
    }

}
