package com.tqminh.vn.toeicpractice.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.tqminh.vn.toeicpractice.cache.QuestionCache;
import com.tqminh.vn.toeicpractice.common.TypeDefinition;
import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.model.PhotoQuestion;
import com.tqminh.vn.toeicpractice.repositories.MCQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.PQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.repositories.entities.PQuestionWrapper;

public abstract class AbstractQuestionService {
	
	@Autowired
	private MCQuestionWrapperRepository mcQuestionWrapperRepository;
	
	@Autowired
	private PQuestionWrapperRepository pQuestionWrapperRepository;
	
	@Autowired
	@Qualifier("MCQuestionCache")
	private QuestionCache<MultipleChoiceQuestion> mcCache;
	
	@Autowired
	@Qualifier("PQuestionCache")
	private	QuestionCache<PhotoQuestion> pCache;

	protected void nextQuestion() {
	}
	
	protected void previousQuestion() {
	}
	
	protected AbstractQuestion getQuestion(int index, Integer typeQuestion) throws NullPointerException{
		if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
			return loadMCQuestion(index);
		}
		else if(typeQuestion == TypeDefinition.PHOTO_QUESTION) {
			return loadPQuestion(index);
		}
		return null;
	}
	
	private MultipleChoiceQuestion loadMCQuestion(int index) {
		try {
			getListMCQuestion(TypeDefinition.MULTIPLE_CHOICE_QUESTION);
			MultipleChoiceQuestion question=  mcCache.getQuestion(index);
			return question;
		} catch (Exception e) {	
			throw e;
		}
	}
	
	private PhotoQuestion loadPQuestion(int index) {
		try {
			getListPQuestion(TypeDefinition.PHOTO_QUESTION);
			PhotoQuestion question=  pCache.getQuestion(index);
			return question;
		} catch (Exception e) {	
			throw e;
		}
	}
	
	private void getListMCQuestion(Integer typeQuestion) {
		Random random= new Random();
		try {
			int count = countQuestion(typeQuestion);
			for(int i= 0; i<= 9; i++) {
				long index= random.nextInt(count);
				MCQuestionWrapper questionWrapper= mcQuestionWrapperRepository.findOne(index);
				mcCache.insertQuestion(questionWrapper.getQuestion());
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	private void getListPQuestion(Integer typeQuestion) {
		Random random= new Random();
		try {
			int count = countQuestion(typeQuestion);
			for(int i= 0; i<= 9; i++) {
				long index= random.nextInt(count);
				PQuestionWrapper questionWrapper= pQuestionWrapperRepository.findOne(index);
				pCache.insertQuestion(questionWrapper.getPhotoQuestion());
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	protected int countQuestion(Integer typeQuestion) {
		int count = 0;
		try {
			if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
				count= mcQuestionWrapperRepository.countQuestionById();
			}
			else if(typeQuestion == TypeDefinition.PHOTO_QUESTION){
//				TODO: count number of the question by id.
			}
		} catch (Exception e) {
			throw e;
		}
		return count;
	}
}
