package com.capg.service;

import java.util.UUID;

//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capg.model.Product;


@org.springframework.cloud.openfeign.FeignClient(name="ProductService" , url="localhost:8092")
public interface ProductDetailsProxy {
	
	@GetMapping("/amazon/products/search/{productId}")
	public Product getProductById(@PathVariable UUID productId);

	
}
