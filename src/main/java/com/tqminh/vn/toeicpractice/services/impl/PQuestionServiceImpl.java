package com.tqminh.vn.toeicpractice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tqminh.vn.toeicpractice.model.PhotoQuestion;
import com.tqminh.vn.toeicpractice.repositories.PQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.PQuestionWrapper;
import com.tqminh.vn.toeicpractice.services.AbstractQuestionService;
import com.tqminh.vn.toeicpractice.services.QuestionService;

public class PQuestionServiceImpl extends AbstractQuestionService implements QuestionService<PhotoQuestion>{

	@Autowired
	private PQuestionWrapperRepository repository;
	
	
	@Override
	public String insertQuestion(PhotoQuestion question) {
		try {
			if(question != null) {
				PQuestionWrapper questionWrapper= new PQuestionWrapper(question);
				PQuestionWrapper pQuestionWrapper= repository.save(questionWrapper);
				if(pQuestionWrapper == null) {
					throw new NullPointerException("Can't insert the Photo Question.");
				}
			}
			else {
				throw new NullPointerException();
			}
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

	@Override
	public PhotoQuestion updateQuestion(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhotoQuestion deleteQuestion(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countQuestion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void nextQuestion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previousQuestion() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhotoQuestion getQuestion(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
