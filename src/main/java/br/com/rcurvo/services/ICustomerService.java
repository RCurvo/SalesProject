package br.com.rcurvo.services;

import br.com.rcurvo.domain.Customer;

public interface ICustomerService {

	Boolean save(Customer customer);

	Customer searchByCPF(Long cpf);

	void delete(Long cpf);

	void update(Customer customer);

}
