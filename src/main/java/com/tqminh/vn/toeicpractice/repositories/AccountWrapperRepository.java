package com.tqminh.vn.toeicpractice.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.common.Constant;
import com.tqminh.vn.toeicpractice.repositories.entities.AccountWrapper;

@Transactional
public interface AccountWrapperRepository extends CrudRepository<AccountWrapper, Long>{
	
	@Query(nativeQuery= true, value= Constant.NativeQuery.FIND_ACCOUNT_BY_USER_NAME_AND_PASSWORD)
	AccountWrapper findAccountByUserAndPassword(String username, String password);

}
