package fr.diginamic.imdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.entity.Role;
import fr.diginamic.imdb.repository.FilmRepository;
import fr.diginamic.imdb.repository.RoleRepository;

@Service
public class FilmService extends AbstractService<Film, Integer> {

    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    protected JpaRepository<Film, Integer> getRepository() {
        return filmRepository;
    }

    public Film findByImdbId(String imdbId) {
        return filmRepository.findByImdbId(imdbId);
    }

    // Récupération du film avec son ID
    public Film findById(Integer id) {
        // Assurez-vous que roleRepository est correctement initialisé
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film introuvable"));
        List<Role> roleList = roleRepository.findByFilmId(id);
        film.setRoles(roleList);
        return film;
    }

    public Film getByNom(String nom) {
        if (nom == null || nom.isEmpty()) {
            throw new IllegalArgumentException("Film ne peut pas être vide");
        }

        return filmRepository.findByNom(nom);
    }

    // Ajouter un rôle à un film donné
    public Role addRoleToFilm(Integer id, Role role) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found"));
        role.setFilm(film);
        // film.addRoleToFilm(role); : créer la méthode dans Film
        filmRepository.save(film);

        return roleRepository.save(role); // Pour persister le rôle
    }

    // Modifier un rôle pour un film donné
    public Role updateRole(Integer roleId, String newCharacterName) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        role.setPersonnage(newCharacterName);
        return roleRepository.save(role);
    }

    // Supprimer un rôle pour un film donné
    public void deleteRole(Integer roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Film film = role.getFilm();
        if (film != null) {
            film.getRoles().remove(role);
            filmRepository.save(film); // Pour mettre à jour la liste des rôles dans le film
        }

        roleRepository.delete(role); // Pour supprimer le rôle
    }

    // Trouver les rôles pour un film donné
    public List<Role> findRolesByFilm(Integer id) {
        return roleRepository.findByFilmId(id);
    }

    public Film findFilmById(Integer filmId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findFilmById'");
    }
}
