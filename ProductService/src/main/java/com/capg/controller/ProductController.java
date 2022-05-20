package com.capg.controller;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Product;
import com.capg.service.ProductService;



@RestController
@RequestMapping("/amazon/products")
public class ProductController {
	
	@Autowired
	ProductService prodServ;
	
	
	// add product to database
	@PostMapping("/save")
	public Product saveData(@RequestBody Product product) {
		return prodServ.saveDataToDB(product);
	}
	
	
	// retrieve all products from database
	@GetMapping("/getAllProducts")
	public ArrayList<Product> getAllProducts() {
		return prodServ.findAllProducts();
	}
	
	
	
	// find particular product details from database by product ID
	@GetMapping("/search/{productId}")
	public Product getProductById(@PathVariable UUID productId) {
		return prodServ.getProductDetails(productId);
	}

	
	 

}
