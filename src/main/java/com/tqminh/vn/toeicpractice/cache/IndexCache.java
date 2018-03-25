package com.tqminh.vn.toeicpractice.cache;

import java.util.Set;

public interface IndexCache<T> {
	
	boolean isCheckIndex(String username, long index);
	
	void setIndex(String username, Set<T> set);
	
	void removeIndex(String username);
}
