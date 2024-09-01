package fr.diginamic.imdb.dto;

public class RealisateurDto {
    private String identite;
    private String dateNaissance;
    private String lieuNaissance;
    private String pays;
    private String url;

    public RealisateurDto() {
    }

    public RealisateurDto(String identite, String dateNaissance, String lieuNaissance, String pays, String url) {
        this.identite = identite;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.pays = pays;
        this.url = url;
    }

    public String getIdentite() {
        return identite;
    }

    public void setIdentite(String identite) {
        this.identite = identite;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RealisateurDto [identite=" + identite + ", dateNaissance=" + dateNaissance + ", lieuNaissance="
                + lieuNaissance + ", pays=" + pays + ", url=" + url + "]";
    }

}
