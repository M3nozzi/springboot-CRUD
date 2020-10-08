package com.menozzi.wkmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.menozzi.wkmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

	void save(List<User> asList);

	
}
