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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.zup.entity.Customer;
import br.com.zup.services.CustomerService;

/**
 * Testes de servico do {@link Customer}
 *  
 * @author paulo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

	@Mock
	private CustomerService customerService;
	
	@Before
	public void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	  Mockito.mock(CustomerService.class);
	}
	
	/**
	 * Test for findAll
	 */
	@Test
	public void test4findAll() {
		Mockito.when(customerService.findAll()).thenReturn(getMockCustomers());
		List<Customer> customers = customerService.findAll();
		Assert.assertEquals(customers, getMockCustomers());
		
		verify(customerService).findAll();
	}
		
	/**
	 * Test for findById
	 */
	@Test
	public void test4findById() {
		Mockito.when(customerService.findById(1)).thenReturn(getMockCustomers().get(0));
		Customer customer = customerService.findById(1);
		Assert.assertEquals(customer, getMockCustomers().get(0));
		
		verify(customerService).findById(1);
	}
	
	/**
	 * Test for update
	 */
	@Test
	public void test4update() {
		Customer customerUpdate = getMockCustomers().get(0);
		customerUpdate.setEmail("teste@teste.com");
		
		Mockito.when(customerService.update(getMockCustomers().get(0))).thenReturn(customerUpdate);
		Customer customer = customerService.update(getMockCustomers().get(0));
		Assert.assertEquals(customer, customerUpdate);
		
		verify(customerService).update(getMockCustomers().get(0));
	}
	
	/**
	 * Test for insert
	 */
	@Test
	public void test4insert() {
		doCallRealMethod().when(customerService).insert(getMockCustomers().get(0));
	}
	
	/**
	 * Test for paginate
	 */
	@Test
	public void test4page() {
		Page<Customer> pagedResponse = new PageImpl<Customer>(getMockCustomers());
		
		Mockito.when(customerService.findPage(1, 1, "DESC", "Teste 1")).thenReturn(pagedResponse);
		Page<Customer> result = customerService.findPage(1, 1, "DESC", "Teste 1");
		Assert.assertEquals(result, pagedResponse);
		
		verify(customerService).findPage(1, 1, "DESC", "Teste 1");
	}
	
	/**
	 * Get mock list of customers
	 * 
	 * @return
	 */
	private List<Customer> getMockCustomers() {
		Customer c1 = new Customer(null, "Teste 1", "teste1@gmail.com");
		Customer c2 = new Customer(null, "Teste 2", "teste2@gmail.com");
		Customer c3 = new Customer(null, "Teste 3", "teste3@gmail.com");
		
		List<Customer> list = new ArrayList<>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		
		return list;
	}
	
}
