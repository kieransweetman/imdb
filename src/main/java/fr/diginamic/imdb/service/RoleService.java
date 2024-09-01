package fr.diginamic.imdb.service;

import fr.diginamic.imdb.entity.Acteur;
import fr.diginamic.imdb.entity.Film;
import fr.diginamic.imdb.entity.Role;
import fr.diginamic.imdb.repository.ActeurRepository;
import fr.diginamic.imdb.repository.FilmRepository;
import fr.diginamic.imdb.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends AbstractService<Role, Integer> {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ActeurRepository acteurRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private FilmService filmService;

    @Override
    protected JpaRepository<Role, Integer> getRepository() {
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
        // Vérifiez que le film et l'acteur existent
        Film film = filmRepository.findById(filmId).orElseThrow(() -> new RuntimeException("Film not found"));
        Acteur acteur = acteurRepository.findById(acteurId).orElseThrow(() -> new RuntimeException("Acteur not found"));

        // Créez le rôle et associez-le au film et à l'acteur
        Role role = new Role();
        role.setFilm(film);
        role.setActeur(acteur);
        role.setPersonnage(personnage);

        // Sauvegardez le rôle dans la base de données
        return roleRepository.save(role);
    }

    private Film findFilmById(Integer id) {
        // Implémenter la méthode pour récupérer un Film par son ID
        return new Film(); // Remplacer par la logique réelle
    }

    private Acteur findActeurById(Integer id) {
        // Implémenter la méthode pour récupérer un Acteur par son ID
        return new Acteur(); // Remplacer par la logique réelle
    }

    /**
     * Modifier un rôle existant
     * 
     * @param roleId        ID du rôle
     * @param newPersonnage Nouveau nom du personnage
     * @return Role modifié
     */
    public Role updateRole(Integer roleId, String newPersonnage) {
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
    public void deleteRole(Integer roleId) {
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
    public List<Role> findRolesByFilm(Integer filmId) {
        // Trouver le film par son ID
        Film film = filmService.findById(filmId);

        if (film == null) {
            System.out.println("Film introuvable");
        }

        return roleRepository.findByFilm(film);
    }
}