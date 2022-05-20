package com.capg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capg.model.Payment;

public interface PaymentRepository extends MongoRepository<Payment, Integer> {

}
