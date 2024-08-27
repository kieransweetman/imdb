package fr.diginamic.imdb.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class RoleId implements Serializable {

    private Long filmId;
    private Long acteurId;

    public RoleId() {
    }

    public RoleId(Long filmId, Long acteurId) {
        this.filmId = filmId;
        this.acteurId = acteurId;
    }

    public Long getFilmId() {
        return filmId;
    }

    public void setFilmId(Long filmId) {
        this.filmId = filmId;
    }

    public Long getActeurId() {
        return acteurId;
    }

    public void setActeurId(Long acteurId) {
        this.acteurId = acteurId;
    }

      
}