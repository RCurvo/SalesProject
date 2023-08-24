package br.com.rcurvo.dao.generic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


import br.com.rcurvo.annotation.KeyType;
import br.com.rcurvo.domain.Persistent;
import br.com.rcurvo.exceptions.KeyTypeNotFoundException;

public abstract class GenericDAO<T extends Persistent, E extends Serializable> implements IGenericDAO<T,E> {
	
	private SingletonMap singletonMap;
	
	public abstract Class<T> getClassType();
	
	public abstract void updateData(T entity, T registeredEntity);
	
	public GenericDAO() {
		this.singletonMap = SingletonMap.getInstance();
	}
	
	public E getKey(T entity) throws KeyTypeNotFoundException {
        Field[] fields = entity.getClass().getDeclaredFields();
        E returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(KeyType.class)) {
                KeyType keyType = field.getAnnotation(KeyType.class);
                String methodName = keyType.value();
                try {
                    Method method = entity.getClass().getMethod(methodName);
                    returnValue = (E) method.invoke(entity);
                    return returnValue;
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new KeyTypeNotFoundException("Chave principal do objeto " + entity.getClass() + " não encontrada", e);
                }
            }
        }
        if (returnValue == null) {
            String msg = "Chave principal do objeto " + entity.getClass() + " não encontrada";
            System.out.println("**** ERRO ****" + msg);
            throw new KeyTypeNotFoundException(msg);
        }
		return returnValue;
	}
	
	@Override
	public Boolean register(T entity) throws KeyTypeNotFoundException {
		Map<E,T> internalMap = getMap();
		E key = getKey(entity);
		if(internalMap.containsKey(key)) {
			return true;
		}
		internalMap.put(key, entity);
		return true;
	}

	@Override
	public void delete(E value) {
		Map<E, T> insternalMap = getMap();
        T registeredObject = insternalMap.get(value);
        if (registeredObject != null) {
        	insternalMap.remove(value, registeredObject);
        }
		
	}

	@Override
	public void update(T entity) throws KeyTypeNotFoundException {
		 Map<E, T> internalMap = getMap();
	        E key = getKey(entity);
	        T registeredObject = internalMap.get(key);
	        if (registeredObject != null) {
	            updateData(entity, registeredObject);
	        }
	}

	@Override
	public T search(E value) {
        Map<E, T> internalMap = getMap();
        return internalMap.get(value);
	}

	@Override
	public Collection<T> searchAll() {
	        Map<E, T> internalMap = getMap();
	        return internalMap.values();
	}
	
	private Map<E,T> getMap(){
		Map<E,T> internalMap = (Map<E,T>) this.singletonMap.getMap().get(getClassType());
		if (internalMap == null) {
			internalMap = new HashMap<>();
			this.singletonMap.getMap().put(getClass(), internalMap);
		}
		return internalMap;
	}

}
