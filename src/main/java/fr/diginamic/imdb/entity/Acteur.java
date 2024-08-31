package fr.diginamic.imdb.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author mattb
 */

@Entity
@Table(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String imdbId;

    private String identite;

    private Float taille;

    private String url;

    @OneToMany(mappedBy = "acteur", fetch = FetchType.EAGER)
    private List<CastingPrincipal> castingPrincipals;

    @OneToMany(mappedBy = "acteur", fetch = FetchType.EAGER)
    private List<Role> roles;

    public Acteur() {
    }

    public Acteur(String identite, Float taille, String url) {
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

    public List<CastingPrincipal> getCastingPrincipals() {
        return castingPrincipals;
    }

    public void setCastingPrincipals(List<CastingPrincipal> castingPrincipals) {
        this.castingPrincipals = castingPrincipals;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    @Override
    public String toString() {
        return "Acteur [id=" + id + ", identite=" + identite + ", taille=" + taille + ", url=" + url + "]";
    }

}
