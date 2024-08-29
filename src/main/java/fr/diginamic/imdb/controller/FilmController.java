package fr.diginamic.imdb.controller;

import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.entity.Role;
import fr.diginamic.imdb.entity.RoleId;
import fr.diginamic.imdb.service.FilmService;
import fr.diginamic.imdb.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import fr.diginamic.imdb.entity.Acteur;
import fr.diginamic.imdb.entity.CastingPrincipal;
import fr.diginamic.imdb.entity.CastingPrincipalId;
import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.entity.LieuNaissance;
import fr.diginamic.imdb.entity.Realisateur;
import fr.diginamic.imdb.service.AbstractService;
import fr.diginamic.imdb.service.ActeurService;
import fr.diginamic.imdb.service.CastingPrincipalService;
import fr.diginamic.imdb.service.FilmService;
import fr.diginamic.imdb.service.RealisateurService;

@RestController
@RequestMapping("/films")
public class FilmController {

	@Autowired
	private FilmService filmService;

	@Autowired
	private ActeurService acteurService;

	@Autowired
	private RealisateurService realisateurService;

	@Autowired
	private CastingPrincipalService castingPrincipalService;

	@Autowired
	private RoleService roleService;

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
			CastingPrincipalId castPiD = new CastingPrincipalId();
			castPiD.setActeurId(acteur.getId());
			castPiD.setFilmId(f.getId());
			castP.setId(castPiD);
			castP = castingPrincipalService.save(castP);

			return ResponseEntity.status(HttpStatus.CREATED).body(castP.toString());
		} else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad Casting Principal");

	}

	@DeleteMapping("/{id}/casting/suppress")
	public ResponseEntity<String> supressCasting(@PathVariable Integer id, @RequestBody Acteur acteur) {
		Film f = filmService.getById(id);

		if (f != null) {
			CastingPrincipal castP = new CastingPrincipal();
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

	// Endpoint pour obtenir les détails d'un film par ID
	@GetMapping("/{id}")
	public ResponseEntity<Film> getFilmById(@PathVariable Integer id) {
		Film film = filmService.getById(id);
		return new ResponseEntity<>(film, HttpStatus.OK);
	}

	// Endpoint pour ajouter un rôle à un film
	@PostMapping("/{id}/roles")
	public ResponseEntity<Role> addRoleToFilm(@PathVariable Integer id,
			@RequestParam Integer acteurId,
			@RequestParam String personnage) {
		Role role = roleService.addRoleToFilm(id, acteurId, personnage);
		return new ResponseEntity<>(role, HttpStatus.CREATED);
	}

	// Endpoint pour mettre à jour un rôle dans un film
	@PutMapping("/{id}/roles/{acteurId}")
	public ResponseEntity<Role> updateRole(@PathVariable Integer id,
			@PathVariable Integer acteurId,
			@RequestParam String newPersonnage) {
		RoleId roleId = new RoleId(id, acteurId);
		Role updatedRole = roleService.updateRole(roleId, newPersonnage);
		return new ResponseEntity<>(updatedRole, HttpStatus.OK);
	}

	// Endpoint pour supprimer un rôle d'un film
	@DeleteMapping("/{id}/roles/{acteurId}")
	public ResponseEntity<Void> deleteRole(@PathVariable Integer id,
			@PathVariable Integer acteurId) {
		RoleId roleId = new RoleId(id, acteurId);
		roleService.deleteRole(roleId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// Endpoint pour obtenir tous les rôles associés à un film
	@GetMapping("/{id}/roles")
	public ResponseEntity<List<Role>> getRolesByFilm(@PathVariable Integer id) {
		List<Role> roles = roleService.findRolesByFilm(film);
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}

}
