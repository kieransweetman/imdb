package fr.diginamic.imdb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class LieuNaissanceId implements Serializable {
    @Column(name = "lieu_id")
    private Long lieuId;

    @Column(name = "acteur_id", nullable = true)
    private Long acteurId;

    @Column(name = "realisateur_id", nullable = true)
    private Long realisateurId;

    // Default constructor
    public LieuNaissanceId() {
    }

    // Parameterized constructor
    public LieuNaissanceId(Long lieuId, Long acteurId, Long realisateurId) {
        this.lieuId = lieuId;
        this.acteurId = acteurId;
        this.realisateurId = realisateurId;
    }

    // Getters and setters
    public Long getLieuId() {
        return lieuId;
    }

    public void setLieuId(Long lieuId) {
        this.lieuId = lieuId;
    }

    public Long getActeurId() {
        return acteurId;
    }

    public void setActeurId(Long acteurId) {
        this.acteurId = acteurId;
    }

    public Long getRealisateurId() {
        return realisateurId;
    }

    public void setRealisateurId(Long realisateurId) {
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