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


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Acteur")
    private Long id;

    @Column(nullable = false)
    private String identite;

    private Integer taille;

    private String url;

    // Relations avec d'autres entités
    @OneToMany(mappedBy = "acteur")
    private Set<CastingPrincipal> castingPrincipals = new HashSet<>();

    @OneToMany(mappedBy = "acteur")
    private Set<Role> roles = new HashSet<>();

    public Acteur() {}

    public Acteur(String identite, Integer taille, String url) {
        this.identite = identite;
        this.taille = taille;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<CastingPrincipal> getCastingPrincipals() {
        return castingPrincipals;
    }

    public void setCastingPrincipals(Set<CastingPrincipal> castingPrincipals) {
        this.castingPrincipals = castingPrincipals;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
