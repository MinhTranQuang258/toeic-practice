package com.tqminh.vn.toeicpractice.services.impl;

import com.tqminh.vn.toeicpractice.model.Account;
import com.tqminh.vn.toeicpractice.repositories.AccountWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.AccountWrapper;
import com.tqminh.vn.toeicpractice.services.AccountDAO;

public class AccountDAOImpl implements AccountDAO{

	private AccountWrapperRepository accountWrapperRepository;
	
	@Override
	public String loginAccount(Account account) {
		if(account.getUserName().equals("admin") && account.getPassword().equals("admin")) {
			
		}
		else {
			
		}
		return "";
	}

	@Override
	public void registerAccount(Account account) {
		AccountWrapper accountWrapper= new AccountWrapper(account);
		accountWrapperRepository.save(accountWrapper);
	}

	@Override
	public void updateAccount(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(long id) {
		// TODO Auto-generated method stub
		
	}
}
