package fr.diginamic.imdb.entity;

import jakarta.persistence.*;

@Entity
public class CastingPrincipal {

    @EmbeddedId
    private CastingPrincipalId id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "Id_Film")
    private Film film;

    @ManyToOne
    @MapsId("acteurId")
    @JoinColumn(name = "Id_Acteur")
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

