package com.capg.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cartInfo")
public class Cart {
	
	// instance variables
	@Id
	private long id;   //set id as primary key
	
	
	private UUID userId;
	private UUID productId;
	
	//default constructor
	public Cart() {
		super();
		// TODO Auto-generated constructor stub

	}
	//parameterized constructor
	public Cart(long id, UUID userId, UUID productId) {
		super();
		this.id = id;
		this.userId = userId;
		this.productId = productId;
	}

	//getters and setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getProductId() {
		return productId;
	}

	public void setProductId(UUID productId) {
		this.productId = productId;
	}

	//tostring method
	@Override
	public String toString() {
		return "Cart [id=" + id + ", userId=" + userId + ", productId=" + productId + "]";
	}

	
}

