package br.com.zup.services;

import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.zup.entity.Customer;
import br.com.zup.entity.ItemOrder;
import br.com.zup.entity.Orders;
import br.com.zup.entity.Product;

/**
 * Testes de servico do {@link Orders}
 *  
 * @author paulo
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderServiceTest {
	
	@Mock
	private OrderService orderService;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Before
	public void setUp() throws Exception {
	  MockitoAnnotations.initMocks(this);
	  Mockito.mock(OrderService.class);
	}
	
	/**
	 * Test for findAll with data
	 * @throws ParseException 
	 */
	@Test
	public void test4findAllWithData() throws ParseException {
		Mockito.when(orderService.findAll()).thenReturn(this.getMockOrders());
		
		List<Orders> result = orderService.findAll();
		Assert.assertEquals(result, this.getMockOrders());
		
		verify(orderService).findAll();
	}
	
	/**
	 * Test for findAll no data
	 */
	@Test
	public void test4findAllNoData() {
		Mockito.when(orderService.findAll()).thenReturn(new ArrayList<>());
		
		List<Orders> result = orderService.findAll();
		Assert.assertEquals(result, new ArrayList<>());
		
		verify(orderService).findAll();
	}
	
	/**
	 * Test for findById with data
	 * @throws ParseException
	 */
	@Test
	public void test4findByIdWithData() throws ParseException {
		Mockito.when(orderService.findById(1)).thenReturn(this.getMockOrders().get(0));
		
		Orders result = orderService.findById(1);
		Assert.assertEquals(result, this.getMockOrders().get(0));
		
		verify(orderService).findById(1);
	}
		
	/**
	 * Get mock list of orders
	 * 
	 * @return
	 * @throws ParseException 
	 */
	private List<Orders> getMockOrders() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Product p1 = new Product(1, "produto 1", 12.50);
		Product p2 = new Product(2, "produto 2", 30.00);
		
		Customer c1 = new Customer(1, "cliente 1", "teste1@email.com");
		Customer c2 = new Customer(2, "cliente 2", "teste2@email.com");
		
		Orders order1 = new Orders(1, sdf.parse("30/09/2018 10:32"), c1);
		Orders order2 = new Orders(2, sdf.parse("10/10/2017 19:35"), c2);
		
		ItemOrder itemOrder1 = new ItemOrder(order1, p1, 0.0, 2, 25.00);
		ItemOrder itemOrder2 = new ItemOrder(order2, p2, 0.0, 1, 15.00);
		
		Set<ItemOrder> itens = new HashSet<>();
		itens.add(itemOrder1);
		itens.add(itemOrder2);
		
		order1.setItens(itens);
		order2.setItens(itens);
		
		
		return Arrays.asList(order1, order2);
	}
	

}
