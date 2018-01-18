package br.com.zup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.entity.Orders;
import br.com.zup.exceptions.ObjectNotFoundException;
import br.com.zup.repository.OrderRepository;

/**
 * Controlar serviços de {@link Orders}
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
	public List<Orders> findAll() {
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
	public Orders findById(final Integer id) {
		Orders orders = orderRepository.findOne(id);
		
		if (orders == null) {
			throw new ObjectNotFoundException(String.format("Pedido com o ID %s não foi encontrado.", id));
		}
		
		return orders;
	}
}
