package com.tqminh.vn.toeicpractice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.cache.AccountCache;
import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.common.Constant.Admin;
import com.tqminh.vn.toeicpractice.common.Constant.Page;
import com.tqminh.vn.toeicpractice.model.Account;
import com.tqminh.vn.toeicpractice.repositories.AccountWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.AccountWrapper;
import com.tqminh.vn.toeicpractice.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountWrapperRepository accountWrapperRepository;
	
	@Autowired
	@Qualifier(value= "AccountCache")
	private AccountCache<Account> accountCache;
	
  	@Override
	public String loginAccount(Account account) throws Exception{
		try {
			String username= account.getUsername();
			String password= account.getPassword();
			if(isAdmin(account)) {
				accountCache.put(username, account);
				return Page.QUESTION_PAGE;
			}
			else {
				AccountWrapper accountWrapper=  
						accountWrapperRepository.findAccountByUserAndPassword(username, password);
				if(accountWrapper != null) {
					accountCache.put(username, account);
					return Page.QUESTION_PAGE;
				}
			}
		}catch (Exception e) {
			throw e;
		}
		return null;
	}
  	
  	private Boolean isAdmin(Account account) {
  		String username= account.getUsername();
  		String password= account.getPassword();
  		if(username.equals(Admin.USER_NAME) && password.equals(Admin.PASSWORD)) {
  			return true;
  		}
  		else {
  			return false;
  		}
  	}
  	
	@Override
	public void logout() {
//		accountCache.deteleObject();
	}

	@Override
	public String registerAccount(Account account) {
		AccountWrapper accountWrapper= new AccountWrapper(account);
		AccountWrapper newAccountWrapper= accountWrapperRepository.save(accountWrapper);
		if(newAccountWrapper != null) {
			return Constant.Notification.REGISTERED_SUCCESS;
		}
		else {
			return Constant.Notification.REGISTRATION_FAILED;
		}
	}

	@Override
	public void updateAccount(long id) {
		// TODO: This feature will be updated later.
		
	}

	@Override
	public void deleteAccount(long id) {
		// TODO: This feature will be updated later.
	}
}
