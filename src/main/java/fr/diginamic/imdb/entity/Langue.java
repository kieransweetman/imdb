package fr.diginamic.imdb.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Langue {
    private String langue;

    public Langue() {
    }

    public Langue(String langue) {
        this.langue = langue;
    }

    public String getValue() {
        return langue;
    }

    public void setValue(String langue) {
        this.langue = langue;
    }
}