package com.tqminh.vn.toeicpractice.cache;


public interface Cache<T> {
	
	Object getObject(Object key);
	
	void put(Object key, Object value);
	
	void deteleObject(Object object);
}
