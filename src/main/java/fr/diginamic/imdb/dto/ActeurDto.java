package fr.diginamic.imdb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ActeurDto {

    @JsonProperty("idActeur")
    private Integer id;

    @JsonProperty("personnage")
    private String personnage;

    public ActeurDto() {
    }

    public ActeurDto(Integer id, String personnage) {
        this.id = id;
        this.personnage = personnage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }
}

    