package com.capg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capg.model.OrderDetails;

public interface OrderRepository extends MongoRepository<OrderDetails, Integer> {
	OrderDetails findByOrderId(String order_id);
}
