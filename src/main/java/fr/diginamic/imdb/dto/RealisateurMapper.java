package fr.diginamic.imdb.dto;

import fr.diginamic.imdb.entity.Realisateur;

public class RealisateurMapper {
    public static RealisateurDto toResponseDto(Realisateur realisateur) {
        if (realisateur == null) {
            return null;
        }

        String lieuNaissance = null;
        String pays = null;

        if (realisateur.getLieuNaissance() != null && realisateur.getLieuNaissance().getLieu() != null) {
            lieuNaissance = realisateur.getLieuNaissance().getLieu().getNom();
            if (realisateur.getLieuNaissance().getLieu().getPays() != null) {
                pays = realisateur.getLieuNaissance().getLieu().getPays().getNom();
            }
        }

        RealisateurDto rDto = new RealisateurDto();
        rDto.setIdentite(realisateur.getIdentite());
        rDto.setDateNaissance(
                realisateur.getLieuNaissance().getDate() != null
                        ? realisateur.getLieuNaissance().getDate().toString()
                        : null);
        rDto.setLieuNaissance(lieuNaissance);
        rDto.setPays(pays);
        rDto.setUrl(realisateur.getUrl());

        return rDto;
    }
}