package br.com.zup.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import br.com.zup.entity.Orders;
import br.com.zup.services.OrderService;


/**
 * Controlar as requisições de pedidos
 * 
 * @author paulo
 *
 */
@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService orderService;
	
	/**
	 * API para consultar uma pedido pelo identificador
	 * 
	 * @author paulo
	 * @param id o identificador da pedido
	 * @return o pedido
	 */
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findOrderById(@PathVariable final Integer id) {
		Orders ped = this.orderService.findById(id);
		return ResponseEntity.ok().body(ped);
	}
	
	/**
	 * API para trazer todos os pedidos
	 * 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Orders>> findAll() {
		List<Orders> list = orderService.findAll();
	  
		return ResponseEntity.ok().body(list);
	}

}
