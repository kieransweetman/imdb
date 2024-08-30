package fr.diginamic.imdb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.imdb.dto.LieuNaissanceDto;
import fr.diginamic.imdb.dto.RealisateurDto;
import fr.diginamic.imdb.dto.RealisateurMapper;
import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.entity.LieuNaissanceId;
import fr.diginamic.imdb.entity.Pays;
import fr.diginamic.imdb.entity.Realisateur;
import fr.diginamic.imdb.service.LieuNaissanceService;
import fr.diginamic.imdb.service.LieuService;
import fr.diginamic.imdb.service.PaysService;
import fr.diginamic.imdb.service.RealisateurService;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/realisateur")
public class RealisateurController {

	@Autowired
	private RealisateurService realisateurService;

	@Autowired
	private PaysService paysService;

	@Autowired
	private LieuService lieuService;

	@Autowired
	private LieuNaissanceService lieuNaissanceService;

	@PostMapping
	public ResponseEntity<RealisateurDto> createRealisateur(@RequestBody RealisateurDto realisateur) {

		Realisateur r = new Realisateur(realisateur.getIdentite(), realisateur.getUrl());
		r = realisateurService.save(r);

		if (realisateur.getLieuNaissance() != null) {

			LieuNaissance ln = new LieuNaissance();
			ln.setRealisateur(r);
			Lieu l = lieuService.findByNom(realisateur.getLieuNaissance());
			Pays p = paysService.findByNom(realisateur.getPays());

			if (p == null) {
				p = new Pays();
				p.setNom(realisateur.getPays());
				p = paysService.save(p);
			}
			if (l == null) {
				l = new Lieu();
				l.setNom(realisateur.getLieuNaissance());
				l.setPays(p);
				l = lieuService.save(l);
			}

			LieuNaissance existingLn = lieuNaissanceService.findByRealisateurAndLieu(r,
					l);
			if (existingLn == null) {
				ln.setLieu(l);
				ln.setRealisateur(r);
				ln = lieuNaissanceService.save(ln);
			} else {
				ln = existingLn;
			}

			r.setLieuNaissance(ln);
			Realisateur real = realisateurService.save(r);
			RealisateurDto rDtoResponse = RealisateurMapper.toResponseDto(real);

			return ResponseEntity.status(HttpStatus.ACCEPTED).body(rDtoResponse);
		}

		else {
			RealisateurDto rDtoResponse = RealisateurMapper.toResponseDto(r);
			return ResponseEntity.status(HttpStatus.CONFLICT).body(rDtoResponse);
		}

	}

	@GetMapping
	public ResponseEntity<List<RealisateurDto>> getAllRealisateur() {

		List<Realisateur> listReal = new ArrayList<Realisateur>();

		listReal = realisateurService.getAll();
		List<RealisateurDto> realisateurDtos = listReal.stream()
				.map(RealisateurMapper::toResponseDto)
				.collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(realisateurDtos);
	}

	@PutMapping
	public ResponseEntity<Realisateur> updateRealisateur(@RequestBody Realisateur realisateur) {

		Realisateur real = realisateurService.save(realisateur);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(real);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Realisateur> deleteRealisateur(@PathVariable Integer id) {

		Realisateur real = realisateurService.getById(id);

		if (real.getFilms().isEmpty()) {
			realisateurService.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(real);
		} else {

			return ResponseEntity.status(HttpStatus.CONFLICT).body(real);
		}

	}

}
