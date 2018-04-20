package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.AccountCache;
import com.tqminh.vn.toeicpractice.model.Account;

@Component
public class AccountCacheImpl implements AccountCache<Account> {

    private final Map<String, Account> map;

    public AccountCacheImpl() {
        super();
        this.map = new HashMap<>();
    }

    @Override
    public Account getObject(final String key) {
        return this.map.get(key);
    }

    @Override
    public int getSize() {
        return this.map.size();
    }

    @Override
    public void put(final String key, final Account value) {
        if ((key instanceof String) && (value instanceof Account)) {
            String k = key;
            Account account = value;
            this.map.put(k, account);
        }
    }

    @Override
    public void removeObject(final String key) {
        this.map.remove(key);
    }
}
