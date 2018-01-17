package br.com.zup.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.dto.ProductDTO;
import br.com.zup.entity.Product;
import br.com.zup.services.ProductService;

/**
 * Controlar as requisções de produtos
 * 
 * @author paulo
 *
 */
@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService; 
	
	/**
	 * API para inserir um novo prodouto
	 * 
	 * @param prd produto para cadastrar
	 * @return
	 */
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProductDTO prd) {
		
		Product produto = productService.fromDTO(prd);
		produto = productService.insert(produto);
		
 		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
 				.path("/{id}").buildAndExpand(prd.getId()).toUri();
	 	return ResponseEntity.created(uri).build();
	}
	
	/**
	 * API para trazer todos os produtos
	 * 
	 * @return
	 */
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<Product> list = productService.findAll();
		List<ProductDTO> listDto = list.stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());  
		
		return ResponseEntity.ok().body(listDto);
	}
	
	/**
	 * API para consultar um produto pelo identificador
	 * 
	 * @author paulo
	 * @param id o identificador do produto
	 * @return o produto
	 */
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarClientePeloId(@PathVariable final Integer id) {
		Product cli = this.productService.findById(id);
		return  ResponseEntity.ok().body(cli);
	}
	
	/**
	 * API para alterar dados de um produto
	 * 
	 * @param objDto o noov objeto
	 * @param id o identificador do produto
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ProductDTO prdDto, @PathVariable Integer id) {
		Product prd = productService.fromDTO(prdDto);
		prd.setId(id);
		
		prd = productService.update(prd);
		
		return ResponseEntity.noContent().build();
	}
	
	/**
	 * API para remover um produto
	 * 
	 * @param id o identificador do produto
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		productService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
