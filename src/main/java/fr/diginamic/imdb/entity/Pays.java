package fr.diginamic.imdb.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pays")
public class Pays {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String url;
	
	private String nom;
	
	private String abreviation;

	@OneToMany(mappedBy= "pays")
	private List<Lieu> lieu = new ArrayList<Lieu>();
	
	
	public Pays() {
		super();
	}

	public Pays(Integer id, String url, String nom, String abreviation, List<Lieu> lieu) {
		super();
		this.id = id;
		this.url = url;
		this.nom = nom;
		this.abreviation = abreviation;
		this.lieu = lieu;
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
	
	

	public List<Lieu> getLieu() {
		return lieu;
	}

	public void setLieu(List<Lieu> lieu) {
		this.lieu = lieu;
	}

	@Override
	public String toString() {
		return "Pays [id=" + id + ", url=" + url + ", nom=" + nom + ", abreviation=" + abreviation + ", lieu=" + lieu
				+ "]";
	}

	
	
	
}
