package fr.diginamic.imdb.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class CastingPrincipalId implements Serializable {

    private Long filmId;
    private Long acteurId;
    public CastingPrincipalId() {
    }
    public CastingPrincipalId(Long filmId, Long acteurId) {
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
