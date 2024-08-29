package fr.diginamic.imdb.service;


import fr.diginamic.imdb.entity.Acteur;
import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.entity.Role;
import fr.diginamic.imdb.entity.RoleId;
import fr.diginamic.imdb.repository.ActeurRepository;
import fr.diginamic.imdb.repository.FilmRepository;
import fr.diginamic.imdb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends AbstractService<Role, RoleId> {
    

    @Autowired
    private  FilmRepository filmRepository;
    @Autowired
    private ActeurRepository acteurRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    protected JpaRepository<Role, RoleId> getRepository() {
        return roleRepository;
    }

    /**
     * Ajouter un rôle à un film donné
     * 
     * @param filmId     ID du film
     * @param acteurId   ID de l'acteur
     * @param personnage Nom du personnage
     * @return Role ajouté
     */
    public Role addRoleToFilm(Integer filmId, Integer acteurId, String personnage) {
        // Vérifier si le film et l'acteur existent
        Film film = filmRepository.findById(filmId)
                .orElseThrow(() -> new RuntimeException("Film not found with id: " + filmId));
        Acteur acteur = acteurRepository.findById(acteurId)
                .orElseThrow(() -> new RuntimeException("Acteur not found with id: " + acteurId));

        // Créer un nouvel objet Role
        Role role = new Role(film, acteur, personnage);

        // Sauvegarder le rôle
        return roleRepository.save(role);
    }

    /**
     * Modifier un rôle existant
     * 
     * @param roleId        ID du rôle
     * @param newPersonnage Nouveau nom du personnage
     * @return Role modifié
     */
    public Role updateRole(RoleId roleId, String newPersonnage) {
        // Trouver le rôle existant
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));

        // Mettre à jour le personnage
        role.setPersonnage(newPersonnage);

        // Sauvegarder les changements
        return roleRepository.save(role);
    }

    /**
     * Supprimer un rôle
     * 
     * @param roleId ID du rôle
     */
    public void deleteRole(RoleId roleId) {
        // Trouver le rôle existant
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found with id: " + roleId));

        // Supprimer le rôle
        roleRepository.delete(role);
    }

    /**
     * Trouver les rôles pour un film donné
     * 
     * @param filmId ID du film
     * @return Liste des rôles associés au film
     */
    public List<Role> findRolesByFilm(Film film) {
        return roleRepository.findByFilmId(film.getId());
    }
}