package br.com.zup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.zup.dto.CustomerDTO;
import br.com.zup.entity.Customer;
import br.com.zup.exceptions.DataIntegrityException;
import br.com.zup.exceptions.ObjectNotFoundException;
import br.com.zup.repository.CustomerRepository;

/**
 * Controlar serviços de cliente
 * 
 * @author paulo
 *
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	/**
	 * Trazer todos os clientes cadastrados
	 * 
	 * @return 
	 */
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	/**
	 * Método para buscar um cliente pelo ID
	 * 
	 * @author paulo
	 * @throws ObjectNotFoundException
	 * @param id o identificador do cliente
	 * @return o cliente caso encontre.
	 */
	public Customer findById(final Integer id) {
		Customer cli = customerRepository.findOne(id);
		
		if (cli == null) {
			throw new ObjectNotFoundException(String.format("Cliente com o ID %s não foi encontrado.", id));
		}
		
		return cli;
	}
	
	/**
	 * Atualizar informaçoes de um cliente
	 * 
	 * @param obj
	 * @return
	 */
	public Customer update(Customer obj) {
		Customer newObj = this.findById(obj.getId());
		updateData(newObj, obj);
		return customerRepository.save(newObj);
	}
	
	/**
	 * Atualizar os parametros
	 * 
	 * @param newObj o novo objeto para alterar
	 * @param obj
	 */
	private void updateData(Customer newObj, Customer obj) {
		newObj.setId(obj.getId());
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
	}
	
	/**
	 * Converter CustomerDTO para entidade Customer
	 * 
	 * @param objDto
	 * @return
	 */
	public Customer fromDTO(CustomerDTO objDto) {
		return new Customer(objDto.getId(), objDto.getName(), objDto.getEmail());
	}

	/**
	 * Remover um cliente cadastrado
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		
		this.findById(id);
		
		try {
			customerRepository.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	/**
	 * Método para inserir um novo cliente 
	 * 
	 * @param obj
	 * @return
	 */
	public void insert(Customer obj) {
		try {
			obj.setId(null);
			obj = customerRepository.save(obj);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Esse email já consta na nossa base de dados...");
		}
	}
}
