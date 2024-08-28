package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.repository.FilmRepository;
import fr.diginamic.imdb.repository.RoleRepository;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FilmService extends AbstractService<Film, Integer> {

    @Autowired
    private FilmRepository filmRepository;
    private RoleRepository roleRepository;

    @Override
    protected JpaRepository<Film, Integer> getRepository() {
        return filmRepository;
    }
   // Ajouter un rôle à un film donné
   public Role addRoleToFilm(Long filmId, Role role) {
    Film film = filmRepository.existsById(id)
            .orElseThrow(() -> new RuntimeException("Film not found"));
    
    role.setFilm(film);
    film.getRoles().add(role);
    filmRepository.save(film); 
    
    return roleRepository.save(role); // Pour persister le rôle
}

// Modifier un rôle pour un film donné
public Role updateRole(Long roleId, String newCharacterName) {
    Role role = roleRepository.findById(roleId)
            .orElseThrow(() -> new RuntimeException("Role not found"));
    
    role.setCharacterName(newCharacterName);
    return roleRepository.save(role);
}

// Supprimer un rôle pour un film donné
public void deleteRole(Long roleId) {
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
public List<Role> findRolesByFilm(Long filmId) {
    return roleRepository.findByFilmId(filmId);
}
}