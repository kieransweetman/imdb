package fr.diginamic.imdb.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapsId;

@Entity
public class CastingPrincipal {

    @Embedded
    private CastingPrincipalId id;

    @ManyToMany
    @MapsId("filmId")
    @JoinColumn(name = "id_film")
    private Film film;

    @ManyToMany
    @MapsId("acteurid")
    @JoinColumn(name = "id_acteur")
    private Acteur acteur;

    public CastingPrincipal() {
    }

    public CastingPrincipal(CastingPrincipalId id, Film film, Acteur acteur) {
        this.id = id;
        this.film = film;
        this.acteur = acteur;
    }

    public CastingPrincipalId getId() {
        return id;
    }

    public void setId(CastingPrincipalId id) {
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

}
