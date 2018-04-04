package com.tqminh.vn.toeicpractice.services;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.Result;

public interface StatisticalService {
	
	List<Result> getTopTenScore(String date);
	
	int getConcurrentUser();
	
	Result getResultByUsername(String username, String date);
}
