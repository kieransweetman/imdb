package fr.diginamic.imdb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "lieu_naissance")
public class LieuNaissance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    // @MapsId("lieuId")
    @JoinColumn(name = "lieu_id", nullable = true)
    private Lieu lieu;

    @OneToOne
    // @MapsId("acteurId")
    @JoinColumn(name = "acteur_id", nullable = true)
    private Acteur acteur;

    @OneToOne
    // @MapsId("realisateurId")
    @JoinColumn(name = "realisateur_id", nullable = true)
    private Realisateur realisateur;

    private LocalDate date;

    public LieuNaissance() {
        super();
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Lieu getLieu() {
        return lieu;
    }

    public void setLieu(Lieu lieu) {
        this.lieu = lieu;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public Realisateur getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(Realisateur realisateur) {
        this.realisateur = realisateur;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}