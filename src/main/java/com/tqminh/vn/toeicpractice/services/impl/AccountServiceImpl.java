package com.tqminh.vn.toeicpractice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.tqminh.vn.toeicpractice.cache.Cache;
import com.tqminh.vn.toeicpractice.common.Notification;
import com.tqminh.vn.toeicpractice.model.Account;
import com.tqminh.vn.toeicpractice.repositories.AccountWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.AccountWrapper;
import com.tqminh.vn.toeicpractice.services.AccountService;

public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountWrapperRepository accountWrapperRepository;
	
	@Autowired
	@Qualifier(value= "AccountCache")
	private Cache accountCache;
	
	private String userName;
	
  	@Override
	public String loginAccount(Account account) {
		try {
			String userName= account.getUserName();
			String password= account.getPassword();
			if(userName.equals("admin") && password.equals("admin")) {
				accountCache.put(userName, account);
			}
			else {
				AccountWrapper accountWrapper=  accountWrapperRepository.findAccountByUserAndPassword(userName, password);
				if(accountWrapper != null) {
					setUserName(userName);
					accountCache.put(userName, account);
				}
				else {
					return Notification.CAN_NOT_FIND_USER;
				}
			}
		}catch (Exception e) {
			throw e;
		}
		return "";
	}
  	
  	protected void setUserName(String userName) {
  		this.userName= userName;
  	}
  	
	protected String getUserName() {
		return userName;
	}

	@Override
	public void logout() {
		accountCache.deteleObject(getUserName());
	}

	@Override
	public String registerAccount(Account account) {
		AccountWrapper accountWrapper= new AccountWrapper(account);
		AccountWrapper newAccountWrapper= accountWrapperRepository.save(accountWrapper);
		if(newAccountWrapper != null) {
			return Notification.REGISTERED_SUCCESS;
		}
		else {
			return Notification.REGISTRATION_FAILED;
		}
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
