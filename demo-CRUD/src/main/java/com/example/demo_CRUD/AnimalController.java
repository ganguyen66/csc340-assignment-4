package com.example.demo_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable int id) {
        return animalService.findById(id)
                .map(animal -> ResponseEntity.ok().body(animal))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        Animal createdAnimal = animalService.save(animal);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAnimal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int id, @RequestBody Animal animalDetails) {
        Animal updatedAnimal = animalService.update(id, animalDetails);
        return ResponseEntity.ok(updatedAnimal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnimal(@PathVariable int id) {
        animalService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/species/{species}")
    public List<Animal> getAnimalsBySpecies(@PathVariable String species) {
        return animalService.findBySpecies(species);
    }

    @GetMapping("/search")
    public List<Animal> searchAnimals(@RequestParam String name) {
        return animalService.searchByName(name);
    }
}

