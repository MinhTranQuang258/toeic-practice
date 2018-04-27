package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.IndexCache;

@Component("IndexCache")
public class IndexCacheImpl implements IndexCache<Long> {

    private Map<String, Set<Long>> indexMap;

    public IndexCacheImpl() {
        super();
    }

    @PostConstruct
    private void initialize() {
        this.indexMap = new HashMap<>();
    }

    @Override
    public boolean isCheckIndex(final String username, final long index) {
        if (index == 0) {
            return false;
        }
        return this.indexMap.get(username).add(index);
    }

    @Override
    public void removeIndex(final String username) {
        this.indexMap.remove(username);
    }

    @Override
    public void setIndex(final String username, final Set<Long> set) {
        this.indexMap.put(username, set);
    }
}
