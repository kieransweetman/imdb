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

import fr.diginamic.imdb.entity.Acteur;
import fr.diginamic.imdb.entity.CastingPrincipal;
import fr.diginamic.imdb.entity.CastingPrincipalId;
import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.entity.Realisateur;
// import fr.diginamic.imdb.service.ActeurService;
import fr.diginamic.imdb.service.CastingPrincipalService;
import fr.diginamic.imdb.service.FilmService;
import fr.diginamic.imdb.service.RealisateurService;

@RestController
@RequestMapping("/film")
public class FilmController {

	@Autowired
	private FilmService filmService;

	// @Autowired
	// private ActeurService acteurService;

	@Autowired
	private RealisateurService realisateurService;

	@Autowired
	private CastingPrincipalService castingPrincipalService;

	@PostMapping
	public ResponseEntity<Film> createFilm(@RequestBody Film film) {

		Film newFilm = filmService.save(film);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newFilm);
	}

	@GetMapping
	public ResponseEntity<List<Film>> getAllFilm() {

		List<Film> listFilm = new ArrayList<Film>();

		listFilm = filmService.getAll();

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(listFilm);
	}

	@PutMapping
	public ResponseEntity<Film> updateFilm(@RequestBody Film film) {

		Film newFilm = filmService.save(film);

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newFilm);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Film> deleteFilm(@PathVariable Integer id) {

		Film newFilm = filmService.getById(id);

		filmService.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newFilm);

	}

	@PostMapping("/{id}/casting/add")
	public ResponseEntity<String> addCasting(@PathVariable Integer id, @RequestBody Acteur acteur) {
		Film f = filmService.getById(id);

		if (f != null) {
			CastingPrincipal castP = new CastingPrincipal();
			castP.setActeur(acteur);
			castP.setFilm(f);
			castP = castingPrincipalService.save(castP);

			return ResponseEntity.status(HttpStatus.CREATED).body(castP.toString());
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Casting Principal");

	}

	@DeleteMapping("/{id}/casting/suppress")
	public ResponseEntity<String> supressCasting(@PathVariable Integer id, @RequestBody Acteur acteur) {
		Film f = filmService.getById(id);
		CastingPrincipal castP = castingPrincipalService.findByActeurIdAndFilmId(acteur.getId(), f.getId());

		if (f != null) {
			CastingPrincipalId castPiD = new CastingPrincipalId();
			castPiD.setActeurId(acteur.getId());
			castPiD.setFilmId(f.getId());
			castP.setId(castPiD);

			castingPrincipalService.deleteById(castPiD);

			return ResponseEntity.status(HttpStatus.CREATED).body(castP.toString());
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Casting Principal");

	}

	@PostMapping("/{id}/realisateur/add")
	public ResponseEntity<String> addRealisateur(@PathVariable Integer id, @RequestBody Realisateur realisateur) {
		Film f = filmService.getById(id);

		List<Realisateur> lReal = new ArrayList<Realisateur>();

		if (f != null) {
			lReal.add(realisateur);
			// realisateurService.save(realisateur);
			f.setRealisateur(lReal);
			filmService.save(f);
			return ResponseEntity.status(HttpStatus.CREATED).body(realisateur.toString());
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Realisateur");

	}

	@DeleteMapping("/{id}/realisateur/supress")
	public ResponseEntity<String> supressRealisateur(@PathVariable Integer id, @RequestBody Realisateur realisateur) {
		Film f = filmService.getById(id);

		if (f != null) {

			realisateurService.deleteById(realisateur.getId());

			return ResponseEntity.status(HttpStatus.CREATED).body(realisateur.toString());
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Realisateur");

	}

}
