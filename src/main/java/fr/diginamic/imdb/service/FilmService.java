package fr.diginamic.imdb.service;

import fr.diginamic.imdb.repository.FilmRepository;
import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.entity.Role;
import fr.diginamic.imdb.entity.RoleId;
import fr.diginamic.imdb.repository.RoleRepository;

import java.util.List;

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
   public Role addRoleToFilm(Integer id, Role role) {
    Film film = filmRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Film not found"));
    role.setFilm(film);
    //film.addRoleToFilm(role); : créer la méthode dans Film
    filmRepository.save(film); 
    
    return roleRepository.save(role); // Pour persister le rôle
}

// Modifier un rôle pour un film donné
public Role updateRole(RoleId roleId, String newCharacterName) {
    Role role = roleRepository.findById(roleId)
            .orElseThrow(() -> new RuntimeException("Role not found"));
    
    role.setCharacterName(newCharacterName);
    return roleRepository.save(role);
}

// Supprimer un rôle pour un film donné
public void deleteRole(RoleId roleId) {
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
public List<Role> findRolesByFilm(Integer filmId) {
    return roleRepository.findByFilmId(filmId);
}
}