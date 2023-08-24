package br.com.rcurvo.dao;

import br.com.rcurvo.dao.generic.GenericDAO;
import br.com.rcurvo.domain.Customer;

public class CustomerDAO extends GenericDAO<Customer, Long> implements ICustomerDAO {
	
	public CustomerDAO() {
		super();
	}

	@Override
	public Class<Customer> getClassType() {
		// TODO Auto-generated method stub
		return Customer.class;
	}

	@Override
	public void updateData(Customer entity, Customer registeredEntity) {
		registeredEntity.setCity(entity.getCity());
		registeredEntity.setCpf(entity.getCpf());
		registeredEntity.setAddress(entity.getAddress());
		registeredEntity.setState(entity.getState());
		registeredEntity.setName(entity.getName());
		registeredEntity.setHouseNumber(entity.getHouseNumber());
		registeredEntity.setPhone(entity.getPhone());
	}
		
}
