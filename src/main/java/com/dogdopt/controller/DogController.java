package com.dogdopt.controller;

import com.dogdopt.model.Dog;
import com.dogdopt.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;
import java.util.List;

public class DogController {

    @Autowired
    private DogRepository dogRepository;

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @PostMapping("/dog")
    public ResponseEntity addDog(@RequestBody Dog dog) {
        Dog newDog = dogRepository.save(dog);
        return ResponseEntity.created(URI.create("/" + newDog.getDogId())).build();
    }
}
