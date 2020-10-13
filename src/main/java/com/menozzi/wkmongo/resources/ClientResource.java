package com.menozzi.wkmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.menozzi.wkmongo.domain.Client;
import com.menozzi.wkmongo.dto.ClientDTO;
import com.menozzi.wkmongo.services.ClientService;

@RestController
@RequestMapping(value="/cliente")
public class ClientResource {
	
	@Autowired
	private ClientService service;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClientDTO>> findAll(){
		
		List<Client> list = service.findAll();
		
		List<ClientDTO> listDto = list.stream().map(x -> new ClientDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ClientDTO> findById(@PathVariable String id){
		
		Client obj = service.findById(id);
				
		return ResponseEntity.ok().body(new ClientDTO(obj));
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody ClientDTO objDto){
		
		Client obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();	
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
 	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
 	public ResponseEntity<Void> update(@RequestBody ClientDTO objDto, @PathVariable String id) {
		Client obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
//	@RequestMapping(value="/{id}/AtualizaSaldo", method=RequestMethod.GET)
// 	public ResponseEntity<List<Saldo>> findSaldo(@PathVariable String id) {
//		Client obj = service.findById(id);
//		return ResponseEntity.ok().body(obj.getSaldo());
//	}
//	

}
