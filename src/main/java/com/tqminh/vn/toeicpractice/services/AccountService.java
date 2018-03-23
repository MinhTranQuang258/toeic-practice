package com.tqminh.vn.toeicpractice.services;

import com.tqminh.vn.toeicpractice.model.Account;

public interface AccountService {
	
	String loginAccount(Account account) throws Exception;
	
	void logout();

	String registerAccount(Account account);
	
	void updateAccount(long id);
	
	void deleteAccount(long id);
}
