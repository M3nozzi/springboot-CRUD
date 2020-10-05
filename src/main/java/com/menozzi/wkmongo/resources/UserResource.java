package com.menozzi.wkmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.menozzi.wkmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		User maria = new User("1", "Maria Rossi", "maria@rossi.com");
		User antonio = new User("2", "Antonio Milano", "antonio@milano.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,antonio));
		return ResponseEntity.ok().body(list);
	}

}
