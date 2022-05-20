package com.capg.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.capg.model.Users;

public interface UserRepositiory extends MongoRepository<Users, String> {
	Users findByuserName(String userName);
}
