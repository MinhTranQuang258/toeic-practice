package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.Hashtable;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.Cache;
import com.tqminh.vn.toeicpractice.model.Account;

@Component(value= "AccountCache")
public class AccountCache implements Cache{
	
	private Map<String, Account> map;

	public AccountCache() {
		super();
		map= new Hashtable<>();
	}
	
	@Override
	public Object getObject(Object key) {
		return map.get(key);
	}

	@Override
	public void put(Object key, Object value) {
		String k= (String) key;
		Account account= (Account) value;
		map.put(k, account);
	}
}
