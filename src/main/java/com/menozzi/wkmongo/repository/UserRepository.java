package com.menozzi.wkmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.menozzi.wkmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	
}
