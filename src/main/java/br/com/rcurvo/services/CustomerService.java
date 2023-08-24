/**
 * 
 */
package br.com.rcurvo.services;

import br.com.rcurvo.dao.ICustomerDAO;
import br.com.rcurvo.domain.Customer;
import br.com.rcurvo.exceptions.KeyTypeNotFoundException;


public class CustomerService implements ICustomerService {
	
	private ICustomerDAO customerDAO;
	
	public CustomerService(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	public Boolean save(Customer customer) {
		try {
			customerDAO.register(customer);
		} catch (KeyTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}

	@Override
	public Customer searchByCPF(Long cpf) {
		// TODO Auto-generated method stub
		return customerDAO.search(cpf);
	}

	@Override
	public void delete(Long cpf) {
		customerDAO.delete(cpf);
		
	}


	@Override
	public void update(Customer customer) {
		try {
			customerDAO.update(customer);
		} catch (KeyTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
