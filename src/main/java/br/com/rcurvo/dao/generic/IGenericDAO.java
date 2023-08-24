package br.com.rcurvo.dao.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.rcurvo.domain.Persistent;
import br.com.rcurvo.exceptions.KeyTypeNotFoundException;

public interface IGenericDAO<T extends Persistent, E extends Serializable> {
	
	public Boolean register(T entity) throws KeyTypeNotFoundException;
	
	public void delete(E value);
	
	public void update(T entity) throws KeyTypeNotFoundException;
	
	public T search(E value);
	
	public Collection<T> searchAll();
}
