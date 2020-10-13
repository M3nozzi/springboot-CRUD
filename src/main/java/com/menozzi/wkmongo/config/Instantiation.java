package com.menozzi.wkmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.menozzi.wkmongo.domain.Client;
import com.menozzi.wkmongo.domain.Saldo;
import com.menozzi.wkmongo.dto.OwnerDTO;
import com.menozzi.wkmongo.repository.ClientRepository;
import com.menozzi.wkmongo.repository.SaldoRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private SaldoRepository saldoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		clientRepository.deleteAll();
		
		saldoRepository.deleteAll();
		
		Client angela = new Client(null, "Angela Acerbi", "90258558067" );
		Client maria = new Client(null, "Maria Rossi", "57370238008" );
		Client antonio = new Client(null, "Antonio Martini", "90485609002" );
		
		clientRepository.saveAll(Arrays.asList(angela, maria, antonio));
		
		Saldo saldo1 = new Saldo(null, sdf.parse("09/10/2020"), 4000.00, new OwnerDTO(antonio));

		Saldo saldo2 = new Saldo(null, sdf.parse("10/10/2020"), 6000.00, new OwnerDTO(angela));
		
		
//		CommentDTO c1  = new CommentDTO("Test Comment", sdf.parse("09/10/2020"), new AuthorDTO(natale));
//		CommentDTO c2  = new CommentDTO("Test Comment 2", sdf.parse("07/10/2020"), new AuthorDTO(dante));
//		CommentDTO c3  = new CommentDTO("Test Comment 3", sdf.parse("06/10/2020"), new AuthorDTO(natale));
//		
//		post1.getComments().addAll(Arrays.asList(c1,c2));
//		
//		post2.getComments().addAll(Arrays.asList(c3));
//		
//		postRepository.saveAll(Arrays.asList(post1, post2));
//		
//		angela.getPosts().addAll(Arrays.asList(post1, post2));
//		clientRepository.save(angela);
		
		saldoRepository.saveAll(Arrays.asList(saldo1, saldo2));
		
	}

}
