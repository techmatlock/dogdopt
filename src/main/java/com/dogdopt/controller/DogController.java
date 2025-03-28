package com.dogdopt.controller;

import com.dogdopt.model.Dog;
import com.dogdopt.repository.DogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogRepository dogRepository; // handles database operations for Dog entities

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return (List<Dog>) dogRepository.findAll(); // return JSON response
    }

    @PostMapping("/dog")
    public ResponseEntity<Dog> addDog(@RequestBody Dog dog) { // @RequestBody converts incoming JSON into a Dog object
        Dog newDog = dogRepository.save(dog);
        return ResponseEntity.created(URI.create("/dog/" + newDog.getDogId())).body(newDog); // Location header created "/dog/{dogId}" so client knows where to fetch it
    }

    @DeleteMapping("/dog/{dogId}")
    public ResponseEntity<String> deleteDog(@PathVariable String dogId) {
        dogRepository.deleteById(dogId);
        return ResponseEntity.ok("Success: dogId " + dogId + " was successfully deleted");
    }
}
