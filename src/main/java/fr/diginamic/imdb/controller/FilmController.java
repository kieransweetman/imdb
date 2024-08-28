package fr.diginamic.imdb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.entity.Realisateur;
import fr.diginamic.imdb.service.FilmService;
import fr.diginamic.imdb.service.RealisateurService;

@RestController
@RequestMapping("/film")
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	@PostMapping
	public ResponseEntity<Film> createFilm(@RequestBody Film film) {
		
		Film newFilm = filmService.save(film);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newFilm);
	}
	
	@GetMapping
	public ResponseEntity<List<Film>> getAllFilm() {
		
		List<Film> listFilm= new ArrayList<Film>();
		
		
		listFilm = filmService.getAll();
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(listFilm);
	}
	
	@PutMapping
	public ResponseEntity<Film> updateFilm(@RequestBody Film film){
		
		Film newFilm = filmService.save(film);
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newFilm);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Film> deleteFilm(@PathVariable Integer id) {
		
		Film newFilm = filmService.getById(id);
		
			filmService.deleteById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(newFilm);
		
		
		
	}
}
