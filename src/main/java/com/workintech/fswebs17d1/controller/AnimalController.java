package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    // Define a Map to store Animal objects
    private Map<Integer, Animal> animals = new HashMap<>();

    // GET: Return all animals
    @GetMapping
    public Collection<Animal> getAllAnimals() {
        return animals.values();
    }

    // GET: Return a specific animal by id
    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable int id) {
        return animals.get(id);
    }

    // POST: Add a new animal
    @PostMapping
    public String addAnimal(@RequestBody Animal newAnimal) {
        animals.put(newAnimal.getId(), newAnimal);
        return "Animal added successfully!";
    }

    // PUT: Update an existing animal by id
    @PutMapping("/{id}")
    public String updateAnimal(@PathVariable int id, @RequestBody Animal updatedAnimal) {
        if (animals.containsKey(id)) {
            animals.put(id, updatedAnimal);
            return "Animal updated successfully!";
        }
        return "Animal not found!";
    }

    // DELETE: Remove an animal by id
    @DeleteMapping("/{id}")
    public String deleteAnimal(@PathVariable int id) {
        if (animals.containsKey(id)) {
            animals.remove(id);
            return "Animal deleted successfully!";
        }
        return "Animal not found!";
    }
}
