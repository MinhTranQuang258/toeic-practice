package com.tqminh.vn.toeicpractice.services;

import com.tqminh.vn.toeicpractice.model.Account;

public interface AccountService {

    void deleteAccount(long id);

    String loginAccount(Account account) throws Exception;

    void logout(String username);

    String registerAccount(Account account);

    void updateAccount(long id);
}
