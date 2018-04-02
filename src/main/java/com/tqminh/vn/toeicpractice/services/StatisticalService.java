package com.tqminh.vn.toeicpractice.services;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.Account;

public interface StatisticalService {
	
	List<Account> getTopTenScore(String date);
	
	int getConcurrentUser();
	
}
