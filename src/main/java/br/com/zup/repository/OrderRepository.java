package br.com.zup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.entity.Order;

/**
 * The repository for the order
 * 
 * @author paulo
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	

}
