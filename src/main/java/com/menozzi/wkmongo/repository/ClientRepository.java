package com.menozzi.wkmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.menozzi.wkmongo.domain.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

}
