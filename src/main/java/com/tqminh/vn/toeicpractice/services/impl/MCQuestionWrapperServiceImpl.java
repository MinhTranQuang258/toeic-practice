package com.tqminh.vn.toeicpractice.services.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.services.AbstractQuestionService;
import com.tqminh.vn.toeicpractice.services.QuestionWrapperService;

@Service("MCQuestionWrapperService")
public class MCQuestionWrapperServiceImpl extends AbstractQuestionService implements QuestionWrapperService{

	@Override
	public List<MCQuestionWrapper> findAllQuestionWarraper(String username) throws NullPointerException, SQLException {
		return super.findAllQuestions(username);
	}
	
}
