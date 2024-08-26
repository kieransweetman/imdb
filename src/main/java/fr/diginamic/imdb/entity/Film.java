package fr.diginamic.imdb.entity;

import java.time.Year;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")
public class Film {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String resume;
    private float rating;
    private String langue;
    private Year annee;
    private String url;

    // @ManyToOne
    // @JoinColumn(nom = "pays_id", nullable = false)
    // private Pays pays;

    public Film(String nom, String resume, float rating, String langue, Year annee, String url) {
        this.nom = nom;
        this.resume = resume;
        this.rating = rating;
        this.langue = langue;
        this.annee = annee;
        this.url = url;
    }

    public Film() {
        super();
    }

    @Override
    public String toString() {
        return "Film [id=" + id + ", nom=" + nom + ", resume=" + resume + ", rating=" + rating + ", langue=" + langue
                + ", annee=" + annee + ", url=" + url + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public Year getAnnee() {
        return annee;
    }

    public void setAnnee(Year annee) {
        this.annee = annee;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // public Pays getPays() {
    // return pays;
    // }

    // public void setPays(Pays pays) {
    // this.pays = pays;
    // }

}
