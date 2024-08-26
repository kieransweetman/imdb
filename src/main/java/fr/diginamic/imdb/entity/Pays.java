package fr.diginamic.imdb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pays")
public class Pays {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String url;

	private String nom;

	private String abreviation;

	public Pays() {
		super();
	}

	public Pays(String url, String nom, String abreviation) {
		super();
		this.url = url;
		this.nom = nom;
		this.abreviation = abreviation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAbreviation() {
		return abreviation;
	}

	public void setAbreviation(String abreviation) {
		this.abreviation = abreviation;
	}

	@Override
	public String toString() {
		return "Pays [id=" + id + ", url=" + url + ", nom=" + nom + ", abreviation=" + abreviation + "]";
	}

}
