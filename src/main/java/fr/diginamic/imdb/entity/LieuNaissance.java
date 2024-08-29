package fr.diginamic.imdb.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "lieu_naissance")
public class LieuNaissance {
    @EmbeddedId
    private LieuNaissanceId id;

    @ManyToOne
    @MapsId("lieuId")
    @JoinColumn(name = "lieu_id")
    private Lieu lieu;

    @ManyToOne
    @MapsId("acteurId")
    @JoinColumn(name = "acteur_id", nullable = true)
    private Acteur acteur;

    @ManyToOne
    @MapsId("realisateurId")
    @JoinColumn(name = "realisateur_id", nullable = true)
    private Realisateur realisateur;

    private Date date;
    
    public LieuNaissance() {
		super();
    }
		
		
    public LieuNaissance(Lieu lieu, Acteur acteur, Realisateur realisateur, Date date) {
		super();
		this.lieu = lieu;
		this.acteur = acteur;
		this.realisateur = realisateur;
		this.date = date;
	}

	

	// Getters and setters
    public LieuNaissanceId getId() {
        return id;
    }

    public void setId(LieuNaissanceId id) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}