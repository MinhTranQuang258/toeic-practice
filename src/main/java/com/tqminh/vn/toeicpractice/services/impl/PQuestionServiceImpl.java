package com.tqminh.vn.toeicpractice.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.common.TypeDefinition;
import com.tqminh.vn.toeicpractice.model.PhotoQuestion;
import com.tqminh.vn.toeicpractice.repositories.PQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.PQuestionWrapper;
import com.tqminh.vn.toeicpractice.services.AbstractQuestionService;
import com.tqminh.vn.toeicpractice.services.QuestionService;

@Service("PQuestionService")
public class PQuestionServiceImpl extends AbstractQuestionService implements QuestionService<PhotoQuestion>{

	@Override
	public void submit(String username) {
		super.submit(username, TypeDefinition.PHOTO_QUESTION);
	}

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
	public int nextQuestion(String username) throws Exception {
		return super.nextQuestion(username, TypeDefinition.PHOTO_QUESTION);
	}

	@Override
	public int previousQuestion(String username) throws Exception {
		return super.previousQuestion(username, TypeDefinition.PHOTO_QUESTION);
	}

	@Override
	public double validateQuestion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PhotoQuestion getQuestion(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
