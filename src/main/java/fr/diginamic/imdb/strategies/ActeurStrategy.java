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
        String[] fields = line.split(";");
        String identite = fields[1];
        String dateString = fields[2];

        Float taille = Float.parseFloat(fields[5]);
        String url = fields[6];
        Acteur acteur = new Acteur(identite, taille, url);
        Acteur newActeur = acteurService.save(acteur);

        if (newActeur != null) {
            LieuNaissance ln = new LieuNaissance();
            Lieu lieu = new Lieu();
            lieu.setNom(fields[3]);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(dateString, formatter);
            Date dob = Date.valueOf(date);

            ln.setActeur(newActeur);
            ln.setDate(dob);
        }
    }

}
