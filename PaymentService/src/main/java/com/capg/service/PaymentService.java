package com.capg.service;

import com.capg.model.Payment;

public interface PaymentService {
	public String placeOrder(Payment payment) throws Exception;
}
