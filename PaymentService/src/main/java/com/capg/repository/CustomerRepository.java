package com.capg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capg.model.Customer;



@Repository
public interface CustomerRepository extends MongoRepository<Customer, Integer> {

}

