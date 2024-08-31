package fr.diginamic.imdb.entity;

import jakarta.persistence.Column;
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

    @Column(name = "character_name")
    private String characterName;

    private String personnage;

    public Role() {
    }

    public Role(RoleId id, Film film, Acteur acteur, String characterName, String personnage) {
        this.id = id;
        this.film = film;
        this.acteur = acteur;
        this.characterName = characterName;
        this.personnage = personnage;
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

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
}
