package com.capg.repository;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capg.model.Product;

import org.junit.jupiter.api.Test;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ProductRepositoryTest {
	
		@Autowired
		private ProductRepository productRepo;
		
		UUID uuid = UUID.fromString("7b0349e4-57c1-4f28-bbdd-a2ded32f5e58");
		UUID uuid1 = UUID.fromString("d808b358-0739-4782-86aa-ec315bc6af30");
		UUID uuid2 = UUID.fromString( "64b7ab7c-3732-4b81-98f9-da024c829da8");
		
		
		
		@Test
		public void givenProductShouldReturnProductObject()
		{
			Product a1= new Product("6278cde1a20ddd02d745433f",uuid,"lays",20.0,4.2,"Lays is chips"); //user Input
			
			productRepo.save(a1);  //Data is saved in database
			Product a2= productRepo.findById(a1.getId()).get(); // fetching the data from database
			assertNotNull(a2); //to check if it is returning the automobile object
			assertEquals(a1.getProductID() , a2.getProductID());
		}
		
		@Test
		public void getAllmustReturnAllProducts() {
			
			Product a3=new Product ("627cbb4a70903836cf91cf02",uuid1,"set wet gel",200,2.1,"it is very good product"); //user Input
			Product a4=new Product ("627cbbae70903836cf91cf03",uuid2,"Asus rog laptop"	,75000 ,8,"24gb ram i79650h processor"); // user Input
			productRepo.save(a3); //Data is saved in database
			productRepo.save(a4); //Data is saved in database
			
			List<Product> autoList = (List<Product>) productRepo.findAll();
			assertEquals(uuid2,autoList.get(1).getProductID());
		} 

	}
