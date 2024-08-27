package fr.diginamic.imdb.controller;

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
import fr.diginamic.imdb.entity.Realisateur;
import fr.diginamic.imdb.service.LieuNaissanceService;
import fr.diginamic.imdb.service.RealisateurService;


@RestController
@RequestMapping("/realisateur")
public class RealisateurController {

	@Autowired
	private RealisateurService realisateurService;
	
	@Autowired
	private LieuNaissanceService lieuNaissanceService;
	

	@PostMapping
	public ResponseEntity<String> createRealisateur(@RequestBody Realisateur realisateur) {
		
		LieuNaissance lieuNaiss = new LieuNaissance();
		Lieu lieu = new Lieu();
		
		Realisateur real = realisateurService.save(realisateur);
		lieuNaiss.setRealisateur(real);
		lieuNaiss.setLieu(lieu);
		
		lieuNaissanceService.save(lieuNaiss);
		
		return ResponseEntity.ok("Success !");
	}
	
	
	@GetMapping
	public ResponseEntity<String> readRealisateur() {
		
		realisateurService.getAll();
		
		return ResponseEntity.ok("Success !");
	}
	
	@PutMapping
	public ResponseEntity<String> updateRealisateur(@RequestBody Realisateur realisateur){
		
		
		
		realisateurService.save(realisateur);
		return ResponseEntity.ok("Success !");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRealisateur(@PathVariable Integer id) {
		
		if (realisateurService.getById(id).getFilms().isEmpty()) {
			realisateurService.deleteById(id);
			return ResponseEntity.ok("Success !");
		}
		else {
			
			return ResponseEntity.badRequest().body("The realisateur is associated to some films, cannot delete realisateur !");
		}
		
		
		
	}
	
	
}
