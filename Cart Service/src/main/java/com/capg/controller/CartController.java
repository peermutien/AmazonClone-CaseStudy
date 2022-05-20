package com.capg.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Cart;
import com.capg.model.CartDetails;
import com.capg.service.CartService;

@RestController
@RequestMapping("/amazon/cart")

public class CartController {

	@Autowired
	CartService  addTocartService;
	
	// add items to cart
	@PostMapping("/add")
	public void addToCart(@RequestBody Cart cart)
	{
		addTocartService.addItemTOCartService(cart);
}
	// delete items from cart
	@DeleteMapping("/remove")
	public void removeFromCart(@RequestBody Cart cart)
	{
		addTocartService.removeItemFromCartService(cart);
	}
	
	// display products in a cart for particular customer
	@GetMapping("/show/{userId}")
	public CartDetails showItems(@PathVariable UUID userId) {
		
		return addTocartService.displayAllProductsInCart(userId);
	}
}
	
