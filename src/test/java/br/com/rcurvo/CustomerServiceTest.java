package br.com.rcurvo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rcurvo.dao.CustomerDAOMock;
import br.com.rcurvo.dao.ICustomerDAO;
import br.com.rcurvo.domain.Customer;
import br.com.rcurvo.services.CustomerService;
import br.com.rcurvo.services.ICustomerService;


public class CustomerServiceTest {
	
	private ICustomerService customerService;
	private Customer customer;
	
	public CustomerServiceTest() {
		ICustomerDAO dao = new CustomerDAOMock();
		customerService = new CustomerService(dao);

	}
	
	@Before
	public void init() {
		customer = new Customer();
		customer.setCpf(1234567890l);
		customer.setName("Renan");
		customer.setCity("Maceio");
		customer.setAddress("Address");
		customer.setState("AL");
		customer.setHouseNumber(10);
		customer.setPhone(1111111111l);
		customerService.save(customer);
	}

	@Test
	public void searchCustomer() {
		Customer customerSearched = customerService.searchByCPF(customer.getCpf());
		Assert.assertNotNull(customerSearched);
	}
	
	@Test
	public void saveCustomer() {
		Boolean result = customerService.save(customer);
		Assert.assertTrue(result);
	}
	
	@Test
	public void deleteCustomer() {
		customerService.delete(customer.getCpf());
	}
	
	@Test
	public void updateCustomer() {
		customer.setName("Renan Curvo");
		customerService.update(customer);
		Assert.assertEquals("Renan Curvo", customer.getName());
	}
}
