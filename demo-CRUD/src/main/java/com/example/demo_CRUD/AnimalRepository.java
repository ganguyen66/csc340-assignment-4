package com.example.demo_CRUD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findBySpecies(String species);
    List<Animal> findByNameContaining(String name);
}

