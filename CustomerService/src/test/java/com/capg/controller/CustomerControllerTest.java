package com.capg.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.capg.model.Customer;
import com.capg.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mocMvc;

	@Mock
	private CustomerService as;
	private Customer am;
	private ArrayList<Customer> autolist;
	
	@InjectMocks
	private CustomerController ac;
	
	//gets uuid from string literal
	UUID uuid = UUID.fromString("9b63744b-be8f-4f49-8ca2-86876fbfd76c");
	
	@BeforeEach
	public void setUp() {
	am = new Customer("627a8f2e6796a85f7718bfa4",uuid,"Akhil Kumar","akhil@gmail.com",37,"9419011111","Male","Madhya Pardesh");
	mocMvc= MockMvcBuilders.standaloneSetup(ac).build();
	}
	
	 @Test
	public void addCustomerControllerTest() throws Exception{
	
		when(as.saveDataToDB(any())).thenReturn(am);
		mocMvc.perform(post("/amazon/customers/save")
		.contentType(MediaType.APPLICATION_JSON)
		.content(asJSONString(am)))
		.andDo(MockMvcResultHandlers.print());
		//.andExpect(status().isCreated());
		verify(as,times(1)).saveDataToDB(any());
	} 
	
	@Test
	public void getAllCustomerControllerTest() throws Exception {
	when(as.findAllCustomers()).thenReturn(autolist);
	mocMvc.perform(MockMvcRequestBuilders.get("/amazon/customers/getAllCustomers")
	.contentType(MediaType.APPLICATION_JSON)
	.content(asJSONString(am)))
	.andDo(MockMvcResultHandlers.print());
	verify(as,times(1)).findAllCustomers();
	}

	public static String asJSONString(final Object obj) {
	
	try {

	return new ObjectMapper().writeValueAsString(obj);
	} catch (Exception e) {
	throw new RuntimeException(e);
	}
	}
}