package br.com.rcurvo.dao;

import java.util.Collection;

import br.com.rcurvo.domain.Customer;
import br.com.rcurvo.exceptions.KeyTypeNotFoundException;

public class CustomerDAOMock implements ICustomerDAO {

	@Override
	public Boolean register(Customer entity) throws KeyTypeNotFoundException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void delete(Long value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer entity) throws KeyTypeNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer search(Long value) {
		Customer customer = new Customer();
		customer.setCpf(value);
		return customer;
	}

	@Override
	public Collection<Customer> searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Boolean save(Customer customer) {
//		return true;
//
//	}
//
//	@Override
//	public Customer searchByCPF(Long cpf) {
//		Customer customer = new Customer();
//		customer.setCpf(cpf);
//		return customer;
//	}
//
//	@Override
//	public void delete(Long cpf) {
//		
//	}
//
//	@Override
//	public void update(Customer customer) {
//		// TODO Auto-generated method stub
		
	}
