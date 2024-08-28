package fr.diginamic.imdb.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class RoleId implements Serializable {

    private Integer filmId;
    private Integer acteurId;

    public RoleId() {
    }

    public RoleId(Integer filmId, Integer acteurId) {
        this.filmId = filmId;
        this.acteurId = acteurId;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public Integer getActeurId() {
        return acteurId;
    }

    public void setActeurId(Integer acteurId) {
        this.acteurId = acteurId;
    }

}