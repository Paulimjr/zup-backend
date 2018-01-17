package br.com.zup;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.zup.entity.Customer;
import br.com.zup.repository.CustomerRepository;

@SpringBootApplication
public class ZupBackendApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository clienteRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ZupBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer c1 = new Customer(null, "Paulo Cesar", "pauloc.sistemas@gmail.com");
		Customer c2 = new Customer(null, "Maria Silva", "maria_silva@gmail.com");
		Customer c3 = new Customer(null, "Bruno Oliveira", "brunoo@gmail.com");
		
		clienteRepository.save(Arrays.asList(c1, c2, c3));
	}

}
