package com.capg.service;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.model.Cart;
import com.capg.model.OrderDetails;
import com.capg.model.Payment;
import com.capg.repository.CartRepository;
import com.capg.repository.OrderRepository;
import com.capg.repository.PaymentRepository;
import com.razorpay.*;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	
	@Autowired
	private PaymentRepository pRepo;
	
	@Autowired
	private CartRepository cRepo;
	
	@Autowired
	private OrderRepository oRepo;

	@Override
	public String placeOrder(Payment payment) throws Exception {
		Cart c = cRepo.findById(payment.getCart_id()).get();
		payment.setCart(c);
		pRepo.save(payment);
		//double amount = payment.getCart().getAmount();
		double amount = 100;
		
		var client = new RazorpayClient("rzp_test_3NqsJYAcKTqGKa", "OXS0OMjHMQbNUYqId2LOMm0n");
		
		JSONObject ob = new JSONObject();
		ob.put("amount", amount*100);
		ob.put("currency", "INR");
		ob.put("receipt", "txn_683");
		
		
		//creating order
		Order order = client.orders.create(ob);
		
		
		
		
		
		System.out.println(order);
		
		//save in database
		OrderDetails o = new OrderDetails();
		o.setId(payment.getPid());
		o.setStatus(order.get("status"));
		o.setAmount((int)order.get("amount")/100);
		o.setOrderId(order.get("id"));
//		o.setPaymentId(null);
		o.setReceipt(order.get("receipt"));
		o.setUser(c.getUser());
		
		oRepo.save(o);
		
	
		
		
		return order.toString();
	}

}
