package com.menozzi.wkmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menozzi.wkmongo.domain.Post;
import com.menozzi.wkmongo.dto.PostDTO;
import com.menozzi.wkmongo.repository.PostRepository;
import com.menozzi.wkmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		
		Optional<Post> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto nao encontrado"));
 		
	}
	
	public Post insert(Post obj) {
		return repo.insert(obj);
		
	}
	
	
	public Post fromDTO(PostDTO postDto) {
		
		return new Post(postDto.getId(), postDto.getDate(), postDto.getTitle(), postDto.getBody(), postDto.getAuthor());
	}

}
