package com.tqminh.vn.toeicpractice.cache;

public interface AccountCache<T> {

    T getObject(String key);

    int getSize();

    void put(String key, T value);

    void removeObject(String key);
}
