package com.capg.service;

import java.util.ArrayList;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//import com.capg.exception.CustomerAlreadyExistException;
import com.capg.model.Customer;
import com.capg.repository.CustomerRepository;


@Service
public class CustomerService {

	@Autowired
	CustomerRepository custRepo;

	//saves customer data to database
	public Customer saveDataToDB(Customer customer) {
		customer.setCustomerID(UUID.randomUUID());
		
		/*
		 if(custRepo.existsById(customer.getId())) {
			throw new CustomerAlreadyExistException (); 
			}
		 Customer saveCustomer=custRepo.save(customer);
		 return saveCustomer;
		 */
		
		return custRepo.save(customer);
	}
	
	// finds all customer in database
	public ArrayList<Customer> findAllCustomers() {
		return custRepo.findAll();
	}

	//finds particular customer data as per customer Id
	public Customer getCustomerDetails(UUID customerId) {
		return custRepo.findBycustomerID(customerId);
		
	}
	
	
}




