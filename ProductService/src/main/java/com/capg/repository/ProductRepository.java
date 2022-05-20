package com.capg.repository;



import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capg.model.Product;



@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	@SuppressWarnings("unchecked")
	Product save(Product product);
	ArrayList<Product> findAll();
	Product findByproductID(UUID productId);
	
	
}
