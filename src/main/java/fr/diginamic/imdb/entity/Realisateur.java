package fr.diginamic.imdb.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "realisateur")
public class Realisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String identite;

    private Date dateNaissance;

    private String url;

    // Relation avec Lieu (plusieurs réalisateurs peuvent être nés dans un seul lieu)
    @ManyToMany(mappedBy = "realisateur")
    private LieuNaissance lieuNaissance;

    // Relation ManyToMany avec Film
    @ManyToMany
    @JoinTable(
            name = "Film_Realisateur",
            joinColumns = @JoinColumn(name = "realisateur_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> films;

    public Realisateur() {
		super();
	}

	public Realisateur(String identite, Date dateNaissance, String url, LieuNaissance lieuNaissance) {
		super();
		this.identite = identite;
		this.dateNaissance = dateNaissance;
		this.url = url;
		this.lieuNaissance = lieuNaissance;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
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
}
