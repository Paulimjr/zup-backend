package br.com.zup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.zup.dto.ProductDTO;
import br.com.zup.entity.Order;
import br.com.zup.entity.Product;
import br.com.zup.exceptions.DataIntegrityException;
import br.com.zup.exceptions.ObjectNotFoundException;
import br.com.zup.repository.OrderRepository;
import br.com.zup.repository.ProductRepository;

/**
 * Controlar serviços de pedidos
 * 
 * @author paulo
 *
 */
@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	/**
	 * Trazer todos os pedidos cadastrados
	 * 
	 * @return 
	 */
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	/**
	 * Método para buscar um pedido pelo ID
	 * 
	 * @author paulo
	 * @throws ObjectNotFoundException
	 * @param id o identificador do pedido
	 * @return o pedido caso encontre.
	 */
	public Order findById(final Integer id) {
		Order order = orderRepository.findOne(id);
		
		if (order == null) {
			throw new ObjectNotFoundException(String.format("Pedido com o ID %s não foi encontrado.", id));
		}
		
		return order;
	}
}
