package com.capg.repository;


import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.capg.model.Customer;



@Repository
public interface CustomerRepository extends MongoRepository <Customer, String> {

	@SuppressWarnings("unchecked")
	Customer save(Customer customer);
	ArrayList<Customer> findAll();
	Customer findBycustomerID(UUID customerId);
	
}
