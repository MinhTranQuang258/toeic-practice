package com.tqminh.vn.toeicpractice.services;

import com.tqminh.vn.toeicpractice.model.Account;

/**
 * The Interface AccountService.
 */
public interface AccountService {

    /**
     * Delete account.
     *
     * @param id the id
     */
    void deleteAccount(long id);

    /**
     * Login account.
     *
     * @param account the account
     * @return the string
     * @throws Exception the exception
     */
    String loginAccount(Account account) throws Exception;

    /**
     * Logout.
     *
     * @param username the username
     */
    void logout(String username);

    /**
     * Register account.
     *
     * @param account the account
     * @return the string
     */
    String registerAccount(Account account);

    /**
     * Update account.
     *
     * @param id the id
     */
    void updateAccount(long id);
}
