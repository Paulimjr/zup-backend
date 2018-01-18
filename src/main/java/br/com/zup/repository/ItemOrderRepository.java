package br.com.zup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.entity.ItemOrder;
import br.com.zup.entity.Orders;

/**
 * The repository for the order
 * 
 * @author paulo
 *
 */
@Repository
public interface ItemOrderRepository extends JpaRepository<ItemOrder, Integer> {
	

}
