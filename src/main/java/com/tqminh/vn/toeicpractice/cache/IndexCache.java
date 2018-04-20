package com.tqminh.vn.toeicpractice.cache;

import java.util.Set;

public interface IndexCache<T> {

    boolean isCheckIndex(String username, long index);

    void removeIndex(String username);

    void setIndex(String username, Set<T> set);
}
