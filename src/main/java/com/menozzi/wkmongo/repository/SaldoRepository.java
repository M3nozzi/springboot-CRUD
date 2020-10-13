package com.menozzi.wkmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.menozzi.wkmongo.domain.Saldo;

@Repository
public interface SaldoRepository extends MongoRepository<Saldo, String> {
	
	List<Saldo> findByValueContaining(Double value);

}
