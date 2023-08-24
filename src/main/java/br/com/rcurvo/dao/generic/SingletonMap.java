package br.com.rcurvo.dao.generic;

import java.util.Map;
import java.util.HashMap;

public class SingletonMap {
	
	private static SingletonMap singletonMap;
	
	protected Map<Class, Map<?,?>> map;
	
	private SingletonMap() {
		map = new HashMap<>();
	}
	
	public static SingletonMap getInstance() {
		if (singletonMap == null) {
			singletonMap = new SingletonMap();
		}
		return singletonMap;
	}

	public Map<Class, Map<?,?>> getMap(){
		return this.map;
	}
}
