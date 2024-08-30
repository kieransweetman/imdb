package fr.diginamic.imdb.controller;

import java.util.ArrayList;
import java.util.List;

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

import fr.diginamic.imdb.entity.Lieu;
import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.entity.LieuNaissanceId;
import fr.diginamic.imdb.entity.Realisateur;
import fr.diginamic.imdb.service.LieuNaissanceService;
import fr.diginamic.imdb.service.LieuService;
import fr.diginamic.imdb.service.RealisateurService;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/realisateur")
public class RealisateurController {

	@Autowired
	private RealisateurService realisateurService;
	
	@Autowired
	private LieuService lieuService;
	
	@Autowired
	private LieuNaissanceService lieuNaissanceService;
	

	@PostMapping
	public ResponseEntity<Realisateur> createRealisateur(@RequestBody Realisateur realisateur) {
		
		LieuNaissance lieuNaiss = new LieuNaissance();
		Lieu lieu = new Lieu();
		LieuNaissanceId lieuNaissId = new LieuNaissanceId();
		
		Realisateur real = new Realisateur();
		
		if (realisateur.getLieuNaissance() != null) {
			
			LieuNaissance lN = realisateur.getLieuNaissance();
			realisateur.setLieuNaissance(null);
			
			real = realisateurService.save(realisateur);
		
			System.out.println(lN.toString());
			
			//lieuNaiss.setRealisateur(realisateur);
			//lieu = lieuService.findByNom(realisateur.getLieuNaissance().getNom());
			
			//lieuService.save(lieu);
			
			//lieuNaissId = lieuNaiss.getId();
			
			//lieuNaiss.setLieu(lieu);
			//lieuNaiss.setDate(realisateur.getDateNaissance());
			
			//lieuNaissanceService.save(lieuNaiss);

			
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(real);
		}
	
		else {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(real);
		}
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<Realisateur>> getAllRealisateur() {
		
		List<Realisateur> listReal = new ArrayList<Realisateur>();
		
		
		listReal = realisateurService.getAll();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(listReal);
	}
	
	@PutMapping
	public ResponseEntity<Realisateur> updateRealisateur(@RequestBody Realisateur realisateur){
		
		Realisateur real = realisateurService.save(realisateur);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(real);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Realisateur> deleteRealisateur(@PathVariable Integer id) {
		
		Realisateur real = realisateurService.getById(id);
		
		if (real.getFilms().isEmpty()) {
			realisateurService.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(real);
		}
		else {
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body(real);
		}
		
		
		
	}
	
	
}
