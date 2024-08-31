package fr.diginamic.imdb.dto;

import java.time.Year;
import java.util.List;

import fr.diginamic.imdb.entity.Genre;
import fr.diginamic.imdb.entity.Langue;

public class FilmDto {
    private String nom;
    private String resume;
    private float rating;
    private Langue langue;
    private Year annee;
    private String url;
    private List<GenreDto> genres;

    public FilmDto() {
        super();
    }

    public FilmDto(String nom, String resume, float rating, Langue langue, Year annee, String url,
            List<GenreDto> genres) {
        this.nom = nom;
        this.resume = resume;
        this.rating = rating;
        this.langue = langue;
        this.annee = annee;
        this.url = url;
        this.genres = genres;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Langue getLangue() {
        return langue;
    }

    public void setLangue(Langue langue) {
        this.langue = langue;
    }

    public Year getAnnee() {
        return annee;
    }

    public void setAnnee(Year annee) {
        this.annee = annee;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setGenres(List<GenreDto> genres) {
        this.genres = genres;
    }

    public List<GenreDto> getGenres() {
        return genres;
    }

    @Override
    public String toString() {
        return "FilmDto [nom=" + nom + ", resume=" + resume + ", rating=" + rating + ", langue=" + langue + ", annee="
                + annee + ", url=" + url + ", genres=" + genres + "]";
    }

}
