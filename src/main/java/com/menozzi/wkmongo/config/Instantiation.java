package com.menozzi.wkmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.menozzi.wkmongo.domain.Post;
import com.menozzi.wkmongo.domain.User;
import com.menozzi.wkmongo.dto.AuthorDTO;
import com.menozzi.wkmongo.repository.PostRepository;
import com.menozzi.wkmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		
		postRepository.deleteAll();
		
		User angela = new User(null, "Angela Acerbi", "angela@acerbi.com" );
		User natale = new User(null, "Natale Mignone", "natale@mignone.com" );
		User dante = new User(null, "Dante Martini", "dante@martini.com" );
		
		userRepository.saveAll(Arrays.asList(angela, natale, dante));
		
		Post post1 = new Post(null, sdf.parse("09/10/2020"), "Test Title", " test test test test!!", new AuthorDTO(angela));
		
		Post post2 = new Post(null, sdf.parse("08/10/2020"), "Test Title 2 ", " test2 test2 test2 test2!!", new AuthorDTO(angela));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		angela.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(angela);
		
	}

}
