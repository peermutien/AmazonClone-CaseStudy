package com.capg.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.model.Product;
import com.capg.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepo;
	
	//saves product data to database								
	public Product saveDataToDB(Product product) {
		product.setProductID(UUID.randomUUID());
		return productRepo.save(product);
	}
	
	// finds all product in database
	public ArrayList<Product> findAllProducts() {
		return productRepo.findAll();
	}
	
	//finds particular product data as per product Id
	public Product getProductDetails(UUID productId) {
		return productRepo.findByproductID(productId);
	}
	

	
}
