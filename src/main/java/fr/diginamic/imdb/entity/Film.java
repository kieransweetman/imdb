package fr.diginamic.imdb.entity;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")
public class Film {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;

    private String imdb_id;

    @Column(columnDefinition = "TEXT")
    private String resume;
    private float rating;

    @Embedded
    private Langue langue;
    private Year annee;
    private String url;

    @ManyToMany
    @JoinTable(name = "Film_Genre", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genres;

    @OneToMany(mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tourner> tournages;

    @ManyToOne
    @JoinColumn(name = "pays_id", nullable = false)
    private Pays pays;

    // Relation ManyToMany avec Film
    @ManyToMany
    @JoinTable(name = "Film_Realisateur", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "realisateur_id"))
    private List<Realisateur> realisateur;

    public Film(String nom, String resume, float rating, Langue langue, Year annee, String url) {
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

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
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

    public List<Genre> getGenre() {
        return genres;
    }

    public void setGenre(List<Genre> genres) {
        this.genres = genres;
    }

    public void addGenre(Genre genre) {
        if (this.genres == null) {
            this.genres = new ArrayList<>();
        }
        if (!this.genres.contains(genre)) {
            this.genres.add(genre);
        }
    }

    public String getImdb_id() {
        return imdb_id;
    }

    public void setImdb_id(String imdb_id) {
        this.imdb_id = imdb_id;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public List<Tourner> getTournages() {
        return tournages;
    }

    public void setTournages(List<Tourner> tournages) {
        this.tournages = tournages;
    }

    public List<Realisateur> getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(List<Realisateur> realisateur) {
        this.realisateur = realisateur;
    }

}
