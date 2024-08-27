package fr.diginamic.imdb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LieuNaissanceId implements Serializable {
    @Column(name = "lieu_id")
    private Integer lieuId;

    @Column(name = "acteur_id", nullable = true)
    private Integer acteurId;

    @Column(name = "realisateur_id", nullable = true)
    private Integer realisateurId;

    // Default constructor
    public LieuNaissanceId() {
    }

    // Parameterized constructor
    public LieuNaissanceId(Integer lieuId, Integer acteurId, Integer realisateurId) {
        this.lieuId = lieuId;
        this.acteurId = acteurId;
        this.realisateurId = realisateurId;
    }

    // Getters and setters
    public Integer getLieuId() {
        return lieuId;
    }

    public void setLieuId(Integer lieuId) {
        this.lieuId = lieuId;
    }

    public Integer getActeurId() {
        return acteurId;
    }

    public void setActeurId(Integer acteurId) {
        this.acteurId = acteurId;
    }

    public Integer getRealisateurId() {
        return realisateurId;
    }

    public void setRealisateurId(Integer realisateurId) {
        this.realisateurId = realisateurId;
    }

    // hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(lieuId, acteurId, realisateurId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        LieuNaissanceId that = (LieuNaissanceId) obj;
        return Objects.equals(lieuId, that.lieuId) &&
                Objects.equals(acteurId, that.acteurId) &&
                Objects.equals(realisateurId, that.realisateurId);
    }
}