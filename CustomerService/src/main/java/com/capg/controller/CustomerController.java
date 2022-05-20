package com.capg.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capg.model.Customer;
import com.capg.service.CustomerService;

@RequestMapping("/amazon/customers/")
@RestController
public class CustomerController {
	
	@Autowired
	CustomerService custService;

	// adds customer data to database
	@PostMapping("/save")
	public Customer saveData(@RequestBody Customer customer){
		return custService.saveDataToDB(customer);
	}
	
	// retrieve all customers from database
	@GetMapping("/getAllCustomers")
	public ArrayList<Customer> getAllCustomers() {
		return custService.findAllCustomers();
	}
	
	
	// finds particualr customer details by its id from database
	@GetMapping("find/{customerId}")	
		public Customer getCustomerById(@PathVariable UUID customerId)  {
			return custService.getCustomerDetails(customerId);
	}


}
