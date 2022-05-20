package com.capg.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cartInfo")
public class Cart {
	
	// instance variables
	@Id
	private long id;   //set id as primary key
	private Customer user;
	private UUID userId;
	private UUID productId;
	private double amount;
	private Date created_date;
	private Product product;
	
	//default constructor
	public Cart() {
		super();
		// TODO Auto-generated constructor stub

	}
	//parameterized constructor
	public Cart(long id, UUID userId, UUID productId,double amount , Customer user , Date created_date , Product product) {
		super();
		this.id = id;
		this.userId = userId;
		this.user=user;
		this.productId = productId;
		this.amount=amount;
		this.created_date=created_date;
		this.product=product;
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
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount=amount;
	}
	
	public Customer getUser()
	{
		return user;
	}
	public void setUser(Customer user) {
		this.user=user;
	}
	
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", user=" + user + ", userId=" + userId + ", productId=" + productId + ", amount="
				+ amount + ", created_date=" + created_date + ", product=" + product + "]";
	}


	
	
}

