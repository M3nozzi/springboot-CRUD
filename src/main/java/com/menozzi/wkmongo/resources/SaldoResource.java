package com.menozzi.wkmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.menozzi.wkmongo.domain.Saldo;
import com.menozzi.wkmongo.services.SaldoService;

@RestController
@RequestMapping(value="/saldo")
public class SaldoResource {
	
	@Autowired
	private SaldoService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Saldo> findById(@PathVariable String id){
		
		Saldo obj = service.findById(id);
				
		return ResponseEntity.ok().body(obj);
		
	}
	

}
