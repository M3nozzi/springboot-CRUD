package com.menozzi.wkmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menozzi.wkmongo.domain.Saldo;
import com.menozzi.wkmongo.repository.SaldoRepository;
import com.menozzi.wkmongo.services.exception.ObjectNotFoundException;

@Service
public class SaldoService {
	
	@Autowired
	private SaldoRepository repo;
	
	public Saldo findById(String id) {
		
		Optional<Saldo> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
 		
	}
	
	
	public List<Saldo> findByValue(Double value){
			return repo.findByValueContaining(value);
	}
	
}
