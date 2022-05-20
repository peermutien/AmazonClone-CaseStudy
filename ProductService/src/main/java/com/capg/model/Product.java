package com.capg.model;
import java.util.UUID;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="productData")
public class Product { 
	
	// instance variables
	@Id
	@GeneratedValue    // annotated id with generated value so that id will be generated automatically
	private String id; 
	private UUID productID;
	private String prodName;
	private double prodPrice;
	private double prodRating;
	private String prodDescription;
	
	//default constructor
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	//parameterized constructor
	public Product(String id, UUID productID, String prodName, double prodPrice, double prodRating,
			String prodDescription) {
		super();
		this.id = id;
		this.productID = productID;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodRating = prodRating;
		this.prodDescription = prodDescription;
	}



	//getters and setters
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public UUID getProductID() {
		return productID;
	}


	public void setProductID(UUID productID) {
		this.productID = productID;
	}


	public String getProdName() {
		return prodName;
	}


	public void setProdName(String prodName) {
		this.prodName = prodName;
	}


	public double getProdPrice() {
		return prodPrice;
	}


	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}


	public double getProdRating() {
		return prodRating;
	}


	public void setProdRating(double prodRating) {
		this.prodRating = prodRating;
	}


	public String getProdDescription() {
		return prodDescription;
	}


	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}



	//toString method
	@Override
	public String toString() {
		return "Product [id=" + id + ", productID=" + productID + ", prodName=" + prodName + ", prodPrice=" + prodPrice
				+ ", prodRating=" + prodRating + ", prodDescription=" + prodDescription + "]";
	}
	
}
