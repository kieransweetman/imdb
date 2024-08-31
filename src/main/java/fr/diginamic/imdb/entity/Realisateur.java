package fr.diginamic.imdb.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "realisateur")
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String identite;

    private String url;

    @OneToOne(mappedBy = "realisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private LieuNaissance lieuNaissance;

    // Relation ManyToMany avec Film
    @ManyToMany
    @JoinTable(name = "Film_Realisateur", joinColumns = @JoinColumn(name = "realisateur_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
    private List<Film> films;

    public Realisateur() {
        super();
    }

    public Realisateur(String identite, String url) {
        super();
        this.identite = identite;
        this.url = url;
    }

    // Getters et setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LieuNaissance getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(LieuNaissance lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Realisateur [id=" + id + ", identite=" + identite + ", url=" + url + "]";
    }
}
