package com.capg.repository;
	
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.capg.model.Cart;



@Repository
public interface CartRepository extends MongoRepository<Cart, Long>{

	@SuppressWarnings("unchecked")
	
	//adds customer and product in cart
	Cart save(Cart cart);
	// deletes customer and product from cart
	void delete(Cart cart);
	// displays products in a cart for particular customer
	ArrayList<Cart> findByuserId(UUID userId);

}
