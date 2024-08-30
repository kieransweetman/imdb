package fr.diginamic.imdb.dto;

public class LieuNaissanceDto {
    private String nom;
    private String pays;

    public LieuNaissanceDto(String nom, String pays) {
        this.nom = nom;
        this.pays = pays;
    }

    public LieuNaissanceDto() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "LieuNaissanceDto [nom=" + nom + ", pays=" + pays + "]";
    }

}