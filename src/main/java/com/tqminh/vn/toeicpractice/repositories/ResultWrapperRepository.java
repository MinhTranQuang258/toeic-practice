package com.tqminh.vn.toeicpractice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.tqminh.vn.toeicpractice.repositories.entities.ResultWrapper;

@Transactional
public interface ResultWrapperRepository extends CrudRepository<ResultWrapper, Long>{
    
    @Query(nativeQuery= true, value= "SELECT * FROM result_wrapper WHERE result ->> 'data' = ?1")
    List<ResultWrapper> findResultsByDate(String date);
    
    @Query(nativeQuery= true, value= "SELECT * FROM result_wrapper WHERE result ->> 'date' = '' && result ->> 'username' = ''")
    ResultWrapper findResultByUsername(String date, String username);
}
