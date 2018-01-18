package br.com.zup;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.zup.entity.Customer;
import br.com.zup.entity.ItemOrder;
import br.com.zup.entity.Orders;
import br.com.zup.entity.Product;
import br.com.zup.repository.CustomerRepository;
import br.com.zup.repository.ItemOrderRepository;
import br.com.zup.repository.OrderRepository;
import br.com.zup.repository.ProductRepository;

@SpringBootApplication
public class ZupBackendApplication implements CommandLineRunner {
	
	@Autowired
	private CustomerRepository clienteRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ItemOrderRepository itemOrderRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ZupBackendApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		//inserindo clientes
		Customer c1 = new Customer(null, "Paulo Cesar", "pauloc.sistemas@gmail.com");
		Customer c2 = new Customer(null, "Maria Silva", "maria_silva@gmail.com");
		Customer c3 = new Customer(null, "Bruno Oliveira", "brunoo@gmail.com");
		clienteRepository.save(Arrays.asList(c1, c2, c3));		
		
		//inserindo produtos
		Product p1 = new Product(null, "Produto 1", 12.50);
		Product p2 = new Product(null, "Produto 2", 25.50);
		productRepository.save(Arrays.asList(p1, p2));

		//inserindo pedidos
		Orders order1 = new Orders(null, sdf.parse("30/09/2018 10:32"), c1);
		Orders order2 = new Orders(null, sdf.parse("10/10/2017 19:35"), c2);
		orderRepository.save(Arrays.asList(order1, order2));
		
		// inserindo itens no pedido
		ItemOrder itemOrder1 = new ItemOrder(order1, p1, 0.0, 2, 25.00);
		ItemOrder itemOrder2 = new ItemOrder(order2, p2, 0.0, 1, 15.00);
		itemOrderRepository.save(Arrays.asList(itemOrder1, itemOrder2));
	}

}
