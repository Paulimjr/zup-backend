package br.com.zup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.entity.Product;

/**
 * The repository for the product
 * 
 * @author paulo
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	

}
