package fr.diginamic.imdb.dto;

public class RoleDto {
    private String filmTitle;
    private String acteurName;
    private String personnage;

    // Constructeurs
    public RoleDto() {
    }

    public RoleDto(String filmTitle, String acteurName, String personnage) {
        this.filmTitle = filmTitle;
        this.acteurName = acteurName;
        this.personnage = personnage;
    }

    // Getters et setters
    public String getFilmTitle() {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public String getActeurName() {
        return acteurName;
    }

    public void setActeurName(String acteurName) {
        this.acteurName = acteurName;
    }

    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }

}
