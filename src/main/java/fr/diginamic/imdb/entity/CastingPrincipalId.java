package fr.diginamic.imdb.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class CastingPrincipalId implements Serializable {

    private Integer filmId;
    private Integer acteurId;

    public CastingPrincipalId() {
    }

    public CastingPrincipalId(Integer filmId, Integer acteurId) {
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
