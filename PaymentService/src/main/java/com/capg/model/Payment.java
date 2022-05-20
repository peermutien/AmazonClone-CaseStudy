package com.capg.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Payment")
public class Payment {
	
	@Id
	private int pid;
	private int cart_id;
	private Cart cart;

	public Payment(Cart cart, int pid, int cart_id) {
		super();
		this.cart = cart;
		this.pid = pid;
		this.cart_id = cart_id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", cart_id=" + cart_id + ", cart=" + cart + "]";
	}
	
}
