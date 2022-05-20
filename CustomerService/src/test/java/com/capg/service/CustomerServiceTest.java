package com.capg.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;



import com.capg.model.Customer;

import com.capg.repository.CustomerRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class CustomerServiceTest {
	
	@Mock
	private CustomerRepository ar;
	@InjectMocks
	private CustomerService asl;
	
	//gets uuid from string literal
	UUID uuid = UUID.fromString("9b63744b-be8f-4f49-8ca2-86876fbfd76c");
	UUID uuid1 = UUID.fromString("642df4c0-7292-403a-8033-14504e7374ba");
	UUID uuid2 = UUID.fromString("fe47dde1-ebb7-417c-a719-cb28c6ad0435");

	@Test
	public void TestAddCustomer() {
		Customer a1 = new Customer("627a8f2e6796a85f7718bfa4",uuid,"Akhil Kumar","akhil@gmail.com",37,"9419011111","Male","Madhya Pardesh"); //userinput
		when(ar.save(any())).thenReturn(a1);
		asl.saveDataToDB(a1); //data saved in database 
		verify(ar,times(1)).save(any()); //used to verify that object is called 1 time.
		
	}
	
	
	@Test
	public void testgetAllCustomer() {
		Customer a1=new Customer ("6278ff4444d3831136480aca",uuid1,"Shankar","shankar@gmail.com",55,"7006000001","Male","Banglore"); //userinput
		Customer a2=new Customer ("627936cdb0f72e568c9e5e87",uuid2,"Aaqib","aaqib@gmail.com" , 21,"71111111", "Male","Texas"); //userinput
	
		
		ar.save(a1); //saving info data to database
		ar.save(a2);
	
		
		ArrayList<Customer> autoList = new ArrayList<>();  // creating list object
		autoList.add(a1);
		autoList.add(a2);
		
		when(ar.findAll()).thenReturn(autoList);  //finds all objects and return to autlist
		List<Customer> autolist1=asl.findAllCustomers();
		assertEquals(autoList,autolist1);
		verify(ar,times(1)).save(a1);
		verify(ar,times(1)).findAll();
		}

}