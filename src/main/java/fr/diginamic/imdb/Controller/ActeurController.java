package fr.diginamic.imdb.Controller;
import java.util.List;

import javax.swing.text.html.parser.Entity;

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

    
    @PostMapping("/ajouter")
    public ResponseEntity<Acteur> ajouterActeur(@RequestBody Acteur acteur) {
        Acteur nouvelActeur = acteurService.save(acteur);
        return new ResponseEntity<>(nouvelActeur, HttpStatus.CREATED);
    }
    // Méthode GET pour obtenir tous les acteurs
    @GetMapping
    public ResponseEntity<List<Acteur>> obtenirTousLesActeurs() {
        List<Acteur> acteurs = acteurService.getAll();
        return new ResponseEntity<>(acteurs, HttpStatus.OK);
    }
   
}

