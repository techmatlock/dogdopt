package com.dogdopt.repository;

import com.dogdopt.model.Dog;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface DogRepository extends
        CrudRepository<Dog, String> {
}

