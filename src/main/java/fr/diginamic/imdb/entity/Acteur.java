/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.diginamic.imdb.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author mattb
 */



import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Acteur")
public class Acteur {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identite;

    private Float taille;

    private String url;

    // Relations avec d'autres entités
    @OneToMany(mappedBy = "acteur")
    private Set<CastingPrincipal> castingPrincipals = new HashSet<>();

    @OneToMany(mappedBy = "acteur")
    private Set<Role> roles= new HashSet<>();

    public Acteur(Integer id, String identite, Float taille, String url) {
        this.id = id;
        this.identite = identite;
        this.taille = taille;
        this.url = url;
    }

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

    public Float getTaille() {
        return taille;
    }

    public void setTaille(Float taille) {
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
    

    @Override
    public String toString() {
        return "Acteur [id=" + id + ", identite=" + identite + ", taille=" + taille + ", url=" + url
                + ", castingPrincipals=" + castingPrincipals + "]";
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    
}
