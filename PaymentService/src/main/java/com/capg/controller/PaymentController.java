package com.capg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.model.Payment;
import com.capg.service.PaymentService;

@RestController
@RequestMapping("/api/v1")
public class PaymentController {
	
	@Autowired
	private PaymentService pServ;
	
	@GetMapping("/payment/test")
	public String paymentTest() {
		return "payment test";
	}
	
	@PostMapping("/payment/placeOrder")
	public ResponseEntity<String> placeOrder(@RequestBody Payment payment) throws Exception{
		return new ResponseEntity<String>(pServ.placeOrder(payment), HttpStatus.CREATED);
	}
}
