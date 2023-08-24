package br.com.rcurvo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.rcurvo.dao.CustomerDAOMock;
import br.com.rcurvo.dao.ICustomerDAO;
import br.com.rcurvo.domain.Customer;
import br.com.rcurvo.exceptions.KeyTypeNotFoundException;

public class CustomerDAOTest {
	private ICustomerDAO customerDao;
	private Customer customer;
	
	public CustomerDAOTest() {
		customerDao = new CustomerDAOMock();
		}
	
	@Before
	public void init() throws KeyTypeNotFoundException {
		customer = new Customer();
		customer.setCpf(1234567890l);
		customer.setName("Renan");
		customer.setCity("Maceio");
		customer.setAddress("Address");
		customer.setState("AL");
		customer.setHouseNumber(10);
		customer.setPhone(1111111111l);
		customerDao.register(customer);
	}
	
	@Test
	public void searchCustomer() {
		Customer customerSearched = customerDao.search(customer.getCpf());
		
		Assert.assertNotNull(customerSearched);
	}
	
	@Test
	public void saveCustomer() throws KeyTypeNotFoundException {
		Boolean result = customerDao.register(customer);
		Assert.assertTrue(result);
	
	}
	
	@Test
	public void deleteCustomer() {
		customerDao.delete(customer.getCpf());
	}
	
	@Test
	public void updateCustomer() throws KeyTypeNotFoundException {
		customer.setName("Renan Curvo");
		customerDao.update(customer);
		Assert.assertEquals("Renan Curvo", customer.getName());
	}

}
