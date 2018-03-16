package com.tqminh.vn.toeicpractice.cache;


public interface AccountCache<T> {
	
	Object getObject(Object key);
	
	void put(Object key, Object value);
	
	void deteleObject(Object object);
}
