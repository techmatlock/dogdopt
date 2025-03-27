package com.dogdopt.repository;

import com.dogdopt.model.Dog;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository to connect with DynamoDB and fetch data with queries from
 * dogs table
 */
@EnableScan
public interface DogRepository extends
        CrudRepository<Dog, String> {
}

