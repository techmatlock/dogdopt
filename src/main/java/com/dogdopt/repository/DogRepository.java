package com.dogdopt.repository;

import com.dogdopt.model.Dog;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface to connect with DynamoDB to read and persist data
 */

@EnableScan // allows us to query table with an attribute that's not a partition key
public interface DogRepository extends
        CrudRepository<Dog, String> {
}

