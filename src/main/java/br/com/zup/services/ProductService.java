package br.com.zup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.zup.dto.ProductDTO;
import br.com.zup.entity.Product;
import br.com.zup.exceptions.DataIntegrityException;
import br.com.zup.exceptions.ObjectNotFoundException;
import br.com.zup.repository.ProductRepository;

/**
 * Controlar serviços de produtos
 * 
 * @author paulo
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	/**
	 * Trazer todos os produtos cadastrados
	 * 
	 * @return 
	 */
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	/**
	 * Método para buscar um produto pelo ID
	 * 
	 * @author paulo
	 * @throws ObjectNotFoundException
	 * @param id o identificador do produto
	 * @return o produto caso encontre.
	 */
	public Product findById(final Integer id) {
		Product cli = productRepository.findOne(id);
		
		if (cli == null) {
			throw new ObjectNotFoundException(String.format("Produto com o ID %s não foi encontrado.", id));
		}
		
		return cli;
	}
	
	/**
	 * Atualizar informaçoes de um produto
	 * 
	 * @param obj
	 * @return
	 */
	public Product update(Product obj) {
		Product newObj = this.findById(obj.getId());
		updateData(newObj, obj);
		return productRepository.save(newObj);
	}
	
	/**
	 * Atualizar os parametros
	 * 
	 * @param newObj o novo objeto para alterar
	 * @param obj
	 */
	private void updateData(Product newObj, Product obj) {
		newObj.setId(obj.getId());
		newObj.setName(obj.getName());
		newObj.setPrice(obj.getPrice());
	}
	
	/**
	 * Converter ProductDTO para entidade Product
	 * 
	 * @param objDto
	 * @return
	 */
	public Product fromDTO(ProductDTO objDto) {
		return new Product(objDto.getId(), objDto.getName(), objDto.getPrice());
	}

	/**
	 * Remover um produto cadastrado
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		
		this.findById(id);
		
		try {
			productRepository.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	/**
	 * Método para inserir um novo produto
	 * 
	 * @param obj
	 * @return
	 */
	public Product insert(Product produto) {
		produto.setId(null);
		productRepository.save(produto);
		return produto;
	}
	
	
}
