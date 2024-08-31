package fr.diginamic.imdb.entity;

/**
 *
 * @author mattb
 */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identite;

    private Float taille;

    private String url;

    @OneToMany(mappedBy = "acteur")
    private Set<CastingPrincipal> castingPrincipals = new HashSet<>();

    @OneToMany(mappedBy = "acteur")
    private List<Role> roles;

    public Acteur() {
    }

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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Acteur [id=" + id + ", identite=" + identite + ", taille=" + taille + ", url=" + url + "]";
    }

}
