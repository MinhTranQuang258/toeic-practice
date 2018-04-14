package com.tqminh.vn.toeicpractice.services;

import java.util.List;

import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;

public interface QuestionWrapperService {
	
	List<MCQuestionWrapper> findAllQuestionWarraper(String username);
	
}
