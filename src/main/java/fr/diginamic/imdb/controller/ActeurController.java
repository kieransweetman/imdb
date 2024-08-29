package fr.diginamic.imdb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import fr.diginamic.imdb.entity.Acteur;
import fr.diginamic.imdb.service.ActeurService;

@RestController
@RequestMapping("/api/acteurs")
public class ActeurController {

    @Autowired
    private ActeurService acteurService;

    // Méthode POST pour ajouter un acteur @PostMapping("/api/acteurs/ajouter")
    @PostMapping("/ajouter")
    public ResponseEntity<?> ajouterActeurs(@RequestBody List<Acteur> acteurs) {
        // Logique pour ajouter plusieurs acteurs
        for (Acteur acteur : acteurs) {
            acteurService.save(acteur);
        }
        return ResponseEntity.ok().build();
    }


    // Méthode GET pour obtenir tous les acteurs
    @GetMapping
    public ResponseEntity<List<Acteur>> obtenirTousLesActeurs() {
        List<Acteur> acteurs = acteurService.getAll();
        return new ResponseEntity<>(acteurs, HttpStatus.OK);
    }

    // Méthode PUT pour modifier un acteur
    @PutMapping("/{id}")
    public ResponseEntity<Acteur> modifierActeur(@PathVariable Integer id, @RequestBody Acteur acteurModifie) {
        Optional<Acteur> acteurExistant = Optional.ofNullable(acteurService.getById(id));
        if (acteurExistant.isPresent()) {
            Acteur acteur = acteurExistant.get();
            acteur.setIdentite(acteurModifie.getIdentite());
            acteur.setTaille(acteurModifie.getTaille());
            acteurService.save(acteur); // Save the updated actor
            return new ResponseEntity<>(acteur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Méthode DELETE pour supprimer un acteur par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Acteur> deleteActeur(@PathVariable Integer id) {
        Acteur acteur = acteurService.getById(id); // Récupérer l'acteur par ID
    
        // Vérifier si l'acteur est lié à des films
        if (acteur.getCastingPrincipals().isEmpty() && acteur.getRoles().isEmpty()) {
            acteurService.deleteById(id); // Supprimer l'acteur s'il n'est lié à aucun casting Principal
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(acteur);
        } else {
            // Retourner un conflit si l'acteur est lié à un ou plusieurs casting Principal
            return ResponseEntity.status(HttpStatus.CONFLICT).body(acteur);
        }
    }
}