package com.capg.repository;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.UUID;


import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capg.model.Customer;



import org.junit.jupiter.api.Test;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CustomerRepositoryTest {
	
		//for repository testing , repository object is created
		@Autowired
		private CustomerRepository custRepo;
		
		//gets uuid from string literal
		UUID uuid = UUID.fromString("9b63744b-be8f-4f49-8ca2-86876fbfd76c");
		UUID uuid1 = UUID.fromString("642df4c0-7292-403a-8033-14504e7374ba");
		UUID uuid2 = UUID.fromString("fe47dde1-ebb7-417c-a719-cb28c6ad0435");
		
		
		
		@Test
		public void givenCustomerShouldReturnCustomerObject()
		{
			Customer a1= new Customer("627a8f2e6796a85f7718bfa4",uuid,"Akhil Kumar","akhil@gmail.com",37,"9419011111","Male","Madhya Pardesh"); //user Input
			
			custRepo.save(a1);  //Data is saved in database
			Customer a2= custRepo.findById(a1.getId()).get(); // fetching the data from database
			assertNotNull(a2); //to check if it is returning the automobile object
			assertEquals(a1.getCustomerID() , a2.getCustomerID());
		}
		
		@Test
		public void getAllmustReturnAllCustomers() {
			
			Customer a3=new Customer ("6278ff4444d3831136480aca",uuid1,"Shankar","shankar@gmail.com",55,"7006000001","Male","Banglore"); //user Input
			Customer a4=new Customer ("627936cdb0f72e568c9e5e87",uuid2,"Aaqib","aaqib@gmail.com" , 21,"71111111", "Male","Texas"); // user Input
			custRepo.save(a3); //Data is saved in database
			custRepo.save(a4); //Data is saved in database
			
			//list object is created where customer data is added
			List<Customer> autoList = (List<Customer>) custRepo.findAll();
			assertEquals(uuid2,autoList.get(3).getCustomerID());
		} 

	}
