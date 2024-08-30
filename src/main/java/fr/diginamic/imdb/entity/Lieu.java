package fr.diginamic.imdb.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "lieu")
public class Lieu {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @OneToMany(mappedBy = "lieu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tourner> tournages;

    @ManyToOne
    @JoinColumn(name = "id_pays")
    private Pays pays;

    @OneToMany(mappedBy = "lieu", cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = LieuNaissance.class)
    private List<LieuNaissance> lieuNaissances;

    public Lieu() {
        super();
    }

    public Lieu(String nom, Pays pays) {
        super();
        this.nom = nom;
        this.pays = pays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Tourner> getTournages() {
        return tournages;
    }

    public void setTournages(List<Tourner> tournages) {
        this.tournages = tournages;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Lieu [id=" + id + ", nom=" + nom + ", pays=" + pays + "]";
    }

}
