package com.capg.service;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.model.Cart;
import com.capg.model.CartDetails;
import com.capg.model.Product;
import com.capg.repository.CartRepository;

@Service
public class CartService {
		
		@Autowired
		CartRepository addToCartRepo;
		
		@Autowired
		ProductDetailsProxy productDetailsProxy;
		
		//add items to cart
		public void addItemTOCartService(Cart cart) {
			addToCartRepo.save(cart);
		}
	
		// delete items from cart
		public void removeItemFromCartService(Cart cart){
			addToCartRepo.delete(cart);
		}
		
	
		// displays userId which has added products in cart
		public CartDetails displayAllProductsInCart(UUID userId) {
			
			CartDetails cartDetails =new CartDetails();
			cartDetails.setUserId(userId);
			
			//calls the findByuserId in cart Repository class i,e array list is created 
			ArrayList<Cart> cartList = addToCartRepo.findByuserId(userId);
			ArrayList<Product> productList=new ArrayList<Product>();
			//to iterate over arraylist, used to get details of all the product details from cart
			for(int i=0;i<cartList.size();i++)
			{
				//getting productID of the object and passing productid into proxy server
				Product product =productDetailsProxy.getProductById(cartList.get(i).getProductId());
				productList.add(product);
				
			}
			
			cartDetails.setList(productList);
		
			return cartDetails;
		}
		
}