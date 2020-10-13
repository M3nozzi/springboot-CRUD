package com.menozzi.wkmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menozzi.wkmongo.domain.Client;
import com.menozzi.wkmongo.dto.ClientDTO;
import com.menozzi.wkmongo.repository.ClientRepository;
import com.menozzi.wkmongo.services.exception.ObjectNotFoundException;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repo;
	
	public List<Client> findAll(){
		return repo.findAll();
	}
	
	
	public Client findById(String id) {
		
		Optional<Client> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Client insert(Client obj) {
		return repo.insert(obj);
	}
	
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	
	public Client update(Client obj) {
		Client newObj = findById(obj.getId());
		updateData(newObj, obj);
		
		return repo.save(newObj);
		
	}
	
	
	private void updateData(Client newObj, Client obj) {
		newObj.setName(obj.getName());		
		newObj.setCpf(obj.getCpf());
	}


	public Client fromDTO(ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(),objDto.getCpf());
	}
	
}
