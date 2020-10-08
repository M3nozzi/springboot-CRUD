package com.menozzi.wkmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.menozzi.wkmongo.domain.User;
import com.menozzi.wkmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User angela = new User(null, "Angela Acerbi", "angela@acerbi.com" );
		User natale = new User(null, "Natale Mignone", "natale@mignone.com" );
		User dante = new User(null, "Dante Martini", "dante@martini.com" );
		
		userRepository.saveAll(Arrays.asList(angela, natale, dante));
	}

}
