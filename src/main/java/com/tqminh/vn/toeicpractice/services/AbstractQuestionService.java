package com.tqminh.vn.toeicpractice.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.tqminh.vn.toeicpractice.cache.QuestionListCache;
import com.tqminh.vn.toeicpractice.common.TypeDefinition;
import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.model.PhotoQuestion;
import com.tqminh.vn.toeicpractice.model.list.MCQuestionList;
import com.tqminh.vn.toeicpractice.model.list.PQuestionList;
import com.tqminh.vn.toeicpractice.repositories.MCQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.PQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.repositories.entities.PQuestionWrapper;

public abstract class AbstractQuestionService {
	
	@Autowired
	private MCQuestionWrapperRepository mcQuestionRepository;
	
	@Autowired
	private PQuestionWrapperRepository pQuestionRepository;
	
	@Autowired
	private QuestionListCache<MCQuestionList> mcCache;
	
	@Autowired
	private QuestionListCache<PQuestionList> pCache;
	
	protected void nextQuestion() {
	}
	
	protected void previousQuestion() {
	}
	
	protected AbstractQuestion getQuestion(int index, Integer typeQuestion) throws Exception{
		try {
			if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
//				return loadMCQuestion(index);
			}
			else if(typeQuestion == TypeDefinition.PHOTO_QUESTION) {
//				return loadPQuestion(index);
			}
		}
		catch (Exception e) {
			throw e;
		}
		return null;
	}
	
	private MultipleChoiceQuestion loadMCQuestions(String username, int index) throws Exception{
		MultipleChoiceQuestion question= loadMCQuestionList(username).getQuestions().get(index);
		return question;
	}
	
	private PhotoQuestion loadPQuestions(String username, int index) throws Exception{
		PhotoQuestion question= loadPQuestionList(username).getQuestions().get(index);
		return question;
	}
	
	private MCQuestionList loadMCQuestionList(String username) {
		MCQuestionList questionList= mcCache.getQuestionList(username);
		return questionList;
	}
	
	private PQuestionList loadPQuestionList(String username) {
		PQuestionList questionList= pCache.getQuestionList(username);
		return questionList;
	}
	
	protected void saveCache(String username, Integer typeQuestion) throws Exception {
		if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
			MCQuestionList questionList= getMCQuestionList(typeQuestion);
			mcCache.putQuestionList(username, questionList);
		}
		else if(typeQuestion == TypeDefinition.PHOTO_QUESTION){
			PQuestionList questionList= getPQuestionList(typeQuestion);
			pCache.putQuestionList(username, questionList);
		}
		
	}
	
	private MCQuestionList getMCQuestionList(Integer typeQuestion) throws Exception{
		Random random= new Random();
		int count = countQuestion(typeQuestion);
		long index= random.nextInt(count);
		List<MultipleChoiceQuestion> list= new LinkedList<>();
		for(int i= 0; i<= 9; i++) {
			if(index != 0) {
				MCQuestionWrapper questionWrapper= mcQuestionRepository.findOne(index);
				list.add(questionWrapper.getQuestion());
			}
		}
		
		MCQuestionList questions= new MCQuestionList(list);
		return questions;
	}
	
	private PQuestionList getPQuestionList(Integer typeQuestion) throws Exception{
		Random random= new Random();
		int count = countQuestion(typeQuestion);
		long index= random.nextInt(count);
		List<PhotoQuestion> list= new LinkedList<>();
		for(int i= 0; i<= 9; i++) {
			if(index != 0) {
				PQuestionWrapper questionWrapper= pQuestionRepository.findOne(index);
				list.add(questionWrapper.getPhotoQuestion());
			}
		}
		
		PQuestionList questions= new PQuestionList(list);
		return questions;
	}
	
	protected int countQuestion(Integer typeQuestion) {
		int count = 0;
		try {
			if(typeQuestion == TypeDefinition.MULTIPLE_CHOICE_QUESTION) {
				count= mcQuestionRepository.countQuestionById();
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
