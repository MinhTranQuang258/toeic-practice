package com.tqminh.vn.toeicpractice.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.repositories.entities.AccountWrapper;

/**
 * The Interface AccountWrapperRepository.
 */
@Transactional
public interface AccountWrapperRepository
        extends CrudRepository<AccountWrapper, Long> {

    /**
     * Find account by user and password.
     *
     * @param username the username
     * @param password the password
     * @return the account wrapper
     */
    @Query(nativeQuery = true, value = Constant.NativeQuery.FIND_ACCOUNT_BY_USERNAME_AND_PASSWORD)
    AccountWrapper findAccountByUserAndPassword(
        String username,
        String password);

    /**
     * Find account by username.
     *
     * @param username the username
     * @return the account wrapper
     */
    @Query(nativeQuery = true, value = Constant.NativeQuery.FIND_ACCOUNT_BY_USERNAME)
    AccountWrapper findAccountByUsername(String username);
}
