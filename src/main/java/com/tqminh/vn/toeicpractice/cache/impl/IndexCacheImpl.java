package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.IndexCache;

@Component("IndexCache")
public class IndexCacheImpl implements IndexCache<Long>{

	private Map<String, Set<Long>> indexMap;

	public IndexCacheImpl() {
        super();
        indexMap= new HashMap<>();
    }

    @Override
	public boolean isCheckIndex(String username, long index) {
		if(index == 0) {
			return false;
		}
		return indexMap.get(username).add(index);
	}

	@Override
	public void setIndex(String username, Set<Long> set) {
		indexMap.put(username, set);
	}

	@Override
	public void removeIndex(String username) {
		indexMap.remove(username);
	}
}
