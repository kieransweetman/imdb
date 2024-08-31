package fr.diginamic.imdb.dto;

public class GenreDto {
    private String nom;

    public GenreDto() {
    }

    public GenreDto(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "GenreDto [nom=" + nom + "]";
    }

}
