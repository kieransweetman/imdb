package fr.diginamic.imdb.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class Role {

    @EmbeddedId
    private RoleId id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "id_film")
    private Film film;

    @ManyToOne
    @MapsId("acteurId")
    @JoinColumn(name = "id_acteur")
    private Acteur acteur;

    private String personnage;

    public Role() {
    }

    public RoleId getId() {
        return id;
    }

    public void setId(RoleId id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }

}
