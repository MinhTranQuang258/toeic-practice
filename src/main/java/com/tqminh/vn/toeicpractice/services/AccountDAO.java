package com.tqminh.vn.toeicpractice.services;

import com.tqminh.vn.toeicpractice.model.Account;

public interface AccountDAO {
	
	String loginAccount(Account account);

	void registerAccount(Account account);
	
	void updateAccount(long id);
	
	void deleteAccount(long id);
}
