/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.diginamic.imdb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 *
 * @author mattb
 */
@Entity
@Table(name="Acteur")
public class Acteur {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idActeur;
    private String identite;
    private float taille;
    private String url;

    public Acteur() {
    }

    public Acteur(Long idActeur, String identite, float taille, String url) {
        this.idActeur = idActeur;
        this.identite = identite;
        this.taille = taille;
        this.url = url;
    }

    public Long getIdActeur() {
        return idActeur;
    }

    public void setIdActeur(Long idActeur) {
        this.idActeur = idActeur;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    
    
}
