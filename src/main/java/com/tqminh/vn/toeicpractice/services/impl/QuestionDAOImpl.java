package com.tqminh.vn.toeicpractice.services.impl;

import com.tqminh.vn.toeicpractice.model.Question;
import com.tqminh.vn.toeicpractice.repositories.entities.QuestionWrapper;
import com.tqminh.vn.toeicpractice.services.QuestionDAO;

public class QuestionDAOImpl implements QuestionDAO{

	@Override
	public String createQuestion(Question question) {
		try {
			if(question != null) {
				
			}
			else {
				return "";
			}
		} catch (Exception e) {
			throw e;
		}
		return "";
	}

	@Override
	public QuestionWrapper loadQuestion(long index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionWrapper updateQuestion(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionWrapper deleteQuestion(long id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
