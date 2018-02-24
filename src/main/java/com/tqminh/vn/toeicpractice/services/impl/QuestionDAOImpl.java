package com.tqminh.vn.toeicpractice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tqminh.vn.toeicpractice.model.Question;
import com.tqminh.vn.toeicpractice.repositories.QuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.QuestionWrapper;
import com.tqminh.vn.toeicpractice.services.QuestionService;

public class QuestionDAOImpl implements QuestionService{
	
	@Autowired
	private QuestionWrapperRepository questionWrapperRepository;

	@Override
	public String createQuestion(Question question) {
		try {
			if(question != null) {
				QuestionWrapper questionWrapper= new QuestionWrapper(question);
				QuestionWrapper wrapper= questionWrapperRepository.save(questionWrapper);
				if(wrapper != null) {
					return "";
				}
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
