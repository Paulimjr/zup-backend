package br.com.zup.services;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.zup.entity.Product;

/**
 * Testes de servico do {@link Product}
 *  
 * @author paulo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class ProductServiceTest {

	@Mock
	private ProductService productService;
	
	@Before
	public void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	  Mockito.mock(ProductService.class);
	}
	
	/**
	 * Test for findAll
	 */
	@Test
	public void test4findAll() {
		Mockito.when(productService.findAll()).thenReturn(getMockProducts());
		List<Product> products = productService.findAll();
		Assert.assertEquals(products, getMockProducts());
		
		verify(productService).findAll();
	}
		
	/**
	 * Test for findById
	 */
	@Test
	public void test4findById() {
		Mockito.when(productService.findById(1)).thenReturn(getMockProducts().get(0));
		Product prod = productService.findById(1);
		Assert.assertEquals(prod, getMockProducts().get(0));
		
		verify(productService).findById(1);
	}
	
	/**
	 * Test for update
	 */
	@Test
	public void test4update() {
		Product prodUpdate = getMockProducts().get(0);
		prodUpdate.setName("Produto Teste Update");
		
		Mockito.when(productService.update(getMockProducts().get(0))).thenReturn(prodUpdate);
		Product prod = productService.update(getMockProducts().get(0));
		Assert.assertEquals(prod, prodUpdate);
		
		verify(productService).update(getMockProducts().get(0));
	}
	
	/**
	 * Test for insert
	 */
	@Test
	public void test4insert() {
		doCallRealMethod().when(productService).insert(getMockProducts().get(0));
	}
	
	/**
	 * Get mock list of products
	 * 
	 * @return
	 */
	private List<Product> getMockProducts() {
		Product p1 = new Product(1, "Produto 1", 12.0);
		Product p2 = new Product(2, "Produto 2", 22.40);
		Product p3 = new Product(3, "Produto 3", 150.0);
		
		List<Product> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		return list;
	}
	
}
