package com.capg.model;


import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="customerInfo")
public class Customer {

	@Id
	
	private String id;
	private UUID customerID;
	private String custName;
	private String custEmail;
	private int custAge;
	private String custPhoneNo;
	private String custGender;
	private String custAddress;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String id, UUID customerID, String custName, String custEmail, int custAge, String custPhoneNo,
			String custGender, String custAddress) {
		super();
		this.id = id;
		this.customerID = customerID;
		this.custName = custName;
		this.custEmail = custEmail;
		this.custAge = custAge;
		this.custPhoneNo = custPhoneNo;
		this.custGender = custGender;
		this.custAddress = custAddress;
	}

	public String  getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UUID getCustomerID() {
		return customerID;
	}

	public void setCustomerID(UUID customerID) {
		this.customerID = customerID;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	public String getCustPhoneNo() {
		return custPhoneNo;
	}

	public void setCustPhoneNo(String custPhoneNo) {
		this.custPhoneNo = custPhoneNo;
	}

	public String getCustGender() {
		return custGender;
	}

	public void setCustGender(String custGender) {
		this.custGender = custGender;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerID=" + customerID + ", custName=" + custName + ", custEmail="
				+ custEmail + ", custAge=" + custAge + ", custPhoneNo=" + custPhoneNo + ", custGender=" + custGender
				+ ", custAddress=" + custAddress + "]";
	}

}

