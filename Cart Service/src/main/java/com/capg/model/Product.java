package com.capg.model;

import java.math.BigInteger;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class Product {
	@Getter @Setter
	public String id;
	
	public UUID productID;
	public String prodName;
	public double prodPrice;
	public double prodRating;
	public String prodDescription;
}
