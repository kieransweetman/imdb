package fr.diginamic.imdb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "lieu")
public class Lieu {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_pays")
    private Pays pays;
    
    
    public Lieu() {
		super();
	}

	public Lieu(int id, String nom, Pays pays) {
		super();
		this.id = id;
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
