package com.menozzi.wkmongo.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.menozzi.wkmongo.domain.Post;
import com.menozzi.wkmongo.dto.PostDTO;
import com.menozzi.wkmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	
	@Autowired
	private PostService service;
	
	
	@RequestMapping( value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		
		Post obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}
	
	
	@RequestMapping( value="/{id}/posts",method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody PostDTO postDto){
		
		Post obj = service.fromDTO(postDto);
		
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build();		
		
	}


}
