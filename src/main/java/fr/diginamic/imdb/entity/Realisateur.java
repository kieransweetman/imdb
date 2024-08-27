package fr.diginamic.imdb.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String identite;

    private LocalDate dateNaissance;

    private String url;

    // Relation avec Lieu (plusieurs réalisateurs peuvent être nés dans un seul lieu)
    @ManyToOne
    @JoinColumn(name = "lieu_naissance_id")
    private Lieu lieuNaissance;

    // Relation ManyToMany avec Film
    @ManyToMany
    @JoinTable(
            name = "Film_Realisateur",
            joinColumns = @JoinColumn(name = "realisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> films;

    // Getters et setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Lieu getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(Lieu lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }
}
