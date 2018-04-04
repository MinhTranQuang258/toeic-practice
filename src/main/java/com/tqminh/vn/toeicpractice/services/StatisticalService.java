package com.tqminh.vn.toeicpractice.services;

import java.sql.SQLException;
import java.util.List;

import com.tqminh.vn.toeicpractice.model.Result;

public interface StatisticalService {
	
	List<Result> getTopTenScore(String date) throws SQLException;
	
	int getConcurrentUser() throws SQLException;
	
	Result getResultByUsername(String username, String date) throws SQLException;
}
