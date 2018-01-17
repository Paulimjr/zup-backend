package br.com.zup.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.dto.CustomerDTO;
import br.com.zup.entity.Customer;
import br.com.zup.services.CustomerService;

/**
 * Controlar as requisções de clientes
 * 
 * @author paulo
 *
 */
@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {
	
	@Autowired
	private CustomerService customerService; 
	
	/**
	 * API para trazer todos os clientes
	 * 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CustomerDTO>> findAll() {
		List<Customer> list = customerService.findAll();
		List<CustomerDTO> listDto = list.stream().map(obj -> new CustomerDTO(obj)).collect(Collectors.toList());  
		
		return ResponseEntity.ok().body(listDto);
	}
	
	/**
	 * API para consultar um cliente pelo identificador
	 * 
	 * @author paulo
	 * @param id o identificador do cliente
	 * @return o cliente
	 */
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarClientePeloId(@PathVariable final Integer id) {
		Customer cli = this.customerService.findById(id);
		return  ResponseEntity.ok().body(cli);
	}
	
	/**
	 * API para alterar dados de um cliente
	 * 
	 * @param objDto o noov objeto
	 * @param id o identificador do cliente
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CustomerDTO cliDto, @PathVariable Integer id) {
		Customer cli = customerService.fromDTO(cliDto);
		cli.setId(id);
		
		cli = customerService.update(cli);
		
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * API para remover um cliente
	 * 
	 * @param id o identificador do cliente
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		customerService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
