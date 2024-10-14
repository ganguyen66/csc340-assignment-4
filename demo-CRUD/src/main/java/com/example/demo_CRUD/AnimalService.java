package com.example.demo_CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Optional<Animal> findById(int id) {
        return animalRepository.findById(id);
    }

    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    public Animal update(int id, Animal animalDetails) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new RuntimeException("Animal not found"));
        animal.setName(animalDetails.getName());
        animal.setScientificName(animalDetails.getScientificName());
        animal.setSpecies(animalDetails.getSpecies());
        animal.setHabitat(animalDetails.getHabitat());
        animal.setDescription(animalDetails.getDescription());
        return animalRepository.save(animal);
    }

    public void delete(int id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> findBySpecies(String species) {
        return animalRepository.findBySpecies(species);
    }

    public List<Animal> searchByName(String name) {
        return animalRepository.findByNameContaining(name);
    }
}

