package fr.diginamic.imdb.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Lieu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ville;

    // Relation avec Realisateur (un lieu peut être le lieu de naissance de plusieurs réalisateurs)
    @OneToMany(mappedBy = "lieuNaissance")
    private List<Realisateur> realisateurs;

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<Realisateur> getRealisateurs() {
        return realisateurs;
    }

    public void setRealisateurs(List<Realisateur> realisateurs) {
        this.realisateurs = realisateurs;
    }
}
