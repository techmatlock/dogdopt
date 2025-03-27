package com.dogdopt.controller;

import com.dogdopt.model.Dog;
import com.dogdopt.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class DogController {

    @Autowired
    private DogRepository dogRepository;

    @GetMapping("/dogs")
    public List<Dog> getAllItems() {
        return (List<Dog>) dogRepository.findAll();
    }
}
