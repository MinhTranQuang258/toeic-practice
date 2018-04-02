package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.AccountCache;
import com.tqminh.vn.toeicpractice.model.Account;

@Component
public class AccountCacheImpl implements AccountCache<Account>{
	
	private Map<String, Account> map;

	public AccountCacheImpl() {
		super();
		map= new HashMap<>();
	}
	
	@Override
	public Account getObject(String key) {
		return map.get(key);
	}

	@Override
	public void put(String key, Account value) {
		if((key instanceof String) && (value instanceof Account)) {
			String k= (String) key;
			Account account= (Account) value;
			map.put(k, account);
		}
	}

	@Override
	public void removeObject(String key) {
		map.remove(key);
	}

    @Override
    public int getSize() {
        return map.size();
    }
}
