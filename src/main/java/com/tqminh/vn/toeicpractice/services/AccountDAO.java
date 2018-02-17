package com.tqminh.vn.toeicpractice.services;

import com.tqminh.vn.toeicpractice.model.Account;

public interface AccountDAO {

	void createAccount(Account account);
	
	void updateAccount(long id);
	
	void deleteAccount(long id);
}
