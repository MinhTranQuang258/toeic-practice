package com.tqminh.vn.toeicpractice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.cache.AccountCache;
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
	private AccountCache<Account> accountCache;
	
  	@Override
	public String loginAccount(Account account) throws Exception{
		try {
			String username= account.getUsername();
			String password= account.getPassword();
			if(isAdmin(account)) {
				accountCache.put(username, account);
				return Page.ADMIN_HOME_PAGE;
			}
			else {
				AccountWrapper accountWrapper=  
						accountWrapperRepository.findAccountByUserAndPassword(username, password);
				if(accountWrapper != null) {
					accountCache.put(username, account);
					return Page.USER_HOME_PAGE;
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
	public void logout(String username) {
		accountCache.removeObject(username);
	}
	
	private boolean isCheckRegister(Account account) {
	    if(account.getName() == null || account.getAge() == 0 || account.getPassword() == null){
	        return false;
	    }
	    else if (accountWrapperRepository.findAccountByUsername(account.getUsername())!= null) {
	        return false;
	    }
	    else {
            return true;
        }
	}
	
	private String checkNulledRegister(AccountWrapper accountWrapper) {
	    if(accountWrapper == null) {
	        return "redirect:/displayRegister";
	    }
	    else {
	        return "redirect:/displayLogin";
	    }
	}

	@Override
	public String registerAccount(Account account) {
	    if(!isCheckRegister(account)) {
	        return "redirect:/displayRegister";
	    }
	    else {
	        AccountWrapper accountWrapper= new AccountWrapper(account);
	        AccountWrapper newAccountWrapper= accountWrapperRepository.save(accountWrapper);
	        return checkNulledRegister(newAccountWrapper);
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
