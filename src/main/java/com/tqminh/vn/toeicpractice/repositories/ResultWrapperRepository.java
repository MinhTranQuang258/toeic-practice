package com.tqminh.vn.toeicpractice.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.repositories.entities.ResultWrapper;

@Transactional
public interface ResultWrapperRepository extends CrudRepository<ResultWrapper, Long>{

}
