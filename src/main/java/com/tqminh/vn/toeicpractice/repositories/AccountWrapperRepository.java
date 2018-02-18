package com.tqminh.vn.toeicpractice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.repositories.entities.AccountWrapper;

@Transactional
public interface AccountWrapperRepository extends CrudRepository<AccountWrapper, Long>{
	
}
