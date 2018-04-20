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
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountCache<Account> accountCache;

    @Autowired
    private AccountWrapperRepository accountWrapperRepository;

    private String checkNulledRegister(final AccountWrapper accountWrapper) {
        if (accountWrapper == null) {
            return "redirect:/displayRegister";
        }
        else {
            return "redirect:/displayLogin";
        }
    }

    @Override
    public void deleteAccount(final long id) {
        // TODO: This feature will be updated later.
    }

    private Boolean isAdmin(final Account account) {
        String username = account.getUsername();
        String password = account.getPassword();
        if (username.equals(Admin.USER_NAME)
                && password.equals(Admin.PASSWORD)) {
            return true;
        }
        else {
            return false;
        }
    }

    private boolean isCheckRegister(final Account account) {
        if (account.getName().isEmpty() || (account.getAge() == 0)
                || account.getPassword().isEmpty()) {
            return false;
        }
        else if (this.accountWrapperRepository
            .findAccountByUsername(account.getUsername()) != null) {
            return false;
        }
        else {
            return true;
        }
    }

    @Override
    public String loginAccount(final Account account) throws Exception {
        try {
            String username = account.getUsername();
            String password = account.getPassword();
            if (this.isAdmin(account)) {
                this.accountCache.put(username, account);
                return Page.ADMIN_HOME_PAGE;
            }
            else {
                AccountWrapper accountWrapper = this.accountWrapperRepository
                    .findAccountByUserAndPassword(username, password);
                if (accountWrapper != null) {
                    this.accountCache.put(username, account);
                    return Page.USER_HOME_PAGE;
                }
            }
        }
        catch (Exception e) {
            throw e;
        }
        return null;
    }

    @Override
    public void logout(final String username) {
        this.accountCache.removeObject(username);
    }

    @Override
    public String registerAccount(final Account account) {
        if (!this.isCheckRegister(account)) {
            return "redirect:/displayRegister";
        }
        else {
            AccountWrapper accountWrapper = new AccountWrapper(account);
            AccountWrapper newAccountWrapper = this.accountWrapperRepository
                .save(accountWrapper);
            return this.checkNulledRegister(newAccountWrapper);
        }
    }

    @Override
    public void updateAccount(final long id) {
        // TODO: This feature will be updated later.

    }
}
