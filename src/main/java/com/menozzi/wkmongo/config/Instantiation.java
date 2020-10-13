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
import com.menozzi.wkmongo.dto.TransferDTO;
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
		
		
		TransferDTO t1  = new TransferDTO(5000.00, sdf.parse("09/10/2020"), new OwnerDTO(maria));
		TransferDTO t2  = new TransferDTO(3000.00, sdf.parse("07/10/2020"), new OwnerDTO(maria));
		TransferDTO t3  = new TransferDTO(4500.80, sdf.parse("06/10/2020"), new OwnerDTO(maria));
		
		saldo1.getTransfers().addAll(Arrays.asList(t1,t2));
		
		saldo2.getTransfers().addAll(Arrays.asList(t3));
	
	
		saldoRepository.saveAll(Arrays.asList(saldo1, saldo2));
		
		angela.getSaldo().addAll(Arrays.asList(saldo2));
		clientRepository.save(angela);
		
		antonio.getSaldo().addAll(Arrays.asList(saldo1));
		clientRepository.save(antonio);
		
		
		
	}

}
