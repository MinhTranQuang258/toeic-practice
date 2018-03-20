package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.AccountCache;
import com.tqminh.vn.toeicpractice.model.Account;

@Component(value= "AccountCache")
public class MCAccountCacheImpl implements AccountCache<Account>{
	
	private Map<String, Account> map;

	public MCAccountCacheImpl() {
		super();
		map= new HashMap<>();
	}
	
	@Override
	public Object getObject(Object key) {
		return map.get(key);
	}

	@Override
	public void put(Object key, Object value) {
		if((key instanceof String) && (value instanceof Account)) {
			String k= (String) key;
			Account account= (Account) value;
			map.put(k, account);
		}
	}

	@Override
	public void deteleObject(Object object) {
		if(object instanceof String) {
			map.remove(object);
		}
	}
}
