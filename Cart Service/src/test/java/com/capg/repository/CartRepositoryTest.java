package com.capg.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.capg.model.Cart;


/*
class CartRepositoryTest {

	@Autowired
	private CartRepository addToCartRepo;
	
	UUID uuid = UUID.fromString("642df4c0-7292-403a-8033-14504e7374ba");
	UUID uuid1 = UUID.fromString("642df4c0-7292-403a-8033-14504e7374ba");
	UUID uuid2 = UUID.fromString("fe47dde1-ebb7-417c-a719-cb28c6ad0435");
	
	
	UUID prdid = UUID.fromString("931e5369-40d8-454b-85fd-b2b480e7ebc5");
	
	
	@Test
	public void givenCustomerShouldReturnCustomerObject()
	{
		Cart a1= new Cart(10,uuid,prdid); //user Input
		
		addToCartRepo.save(a1);  //Data is saved in database
		Cart a2= addToCartRepo.findById(a1.getId()).get(); // fetching the data from database
		assertNotNull(a2); //to check if it is returning the automobile object
		assertEquals(a1.getUserId(), a2.getUserId());
	}
	
	/*
	@Test
	public void getAllmustReturnAllCustomers() {
		
		Customer a3=new Customer ("6278ff4444d3831136480aca",uuid1,"Shankar","shankar@gmail.com",55,"7006000001","Male","Banglore"); //user Input
		Customer a4=new Customer ("627936cdb0f72e568c9e5e87",uuid2,"Aaqib","aaqib@gmail.com" , 21,"71111111", "Male","Texas"); // user Input
		custRepo.save(a3); //Data is saved in database
		custRepo.save(a4); //Data is saved in database
		
		List<Customer> autoList = (List<Customer>) custRepo.findAll();
		assertEquals(uuid2,autoList.get(3).getCustomerID());
	}   
}
*/
