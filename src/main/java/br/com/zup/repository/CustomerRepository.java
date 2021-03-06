package br.com.zup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.zup.entity.Customer;

/**
 * The repository for the customer
 * 
 * @author paulo
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	/**
	 * Buscar o cliente pelo email informado
	 * 
	 * @param email
	 * @return
	 */
	@Transactional(readOnly=true)
	Customer findByEmail(final String email);
	

}
