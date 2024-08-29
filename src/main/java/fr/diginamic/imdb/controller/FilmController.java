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

@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService filmService;
    private final RoleService roleService;

    @Autowired
    public FilmController(FilmService filmService, RoleService roleService) {
        this.filmService = filmService;
        this.roleService = roleService;
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
