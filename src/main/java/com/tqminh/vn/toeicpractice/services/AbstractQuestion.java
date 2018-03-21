package com.tqminh.vn.toeicpractice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.tqminh.vn.toeicpractice.cache.QuestionCache;
import com.tqminh.vn.toeicpractice.repositories.MCQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;

public abstract class AbstractQuestion<T> {
	
//	@Autowired
//	private MCQuestionWrapperRepository questionWrapperRepository;
	
	@Autowired
	@Qualifier("QuestionCache")
	private QuestionCache<T> cache;

	protected void nextQuestion() {
	}
	
	protected void previousQuestion() {
	}
	
//	protected List<Integer> getRandomQuestionById(){
//		List<Integer> list= new ArrayList<Integer>();
//		
//	}
	
//	protected T getQuestion(int index) {
//		return loadQuestion(index);
//	}
	
//	private T loadQuestion(int index) {
//		try {
//			getListQuestion();
//			T question=  cache.getQuestion(index);
//			return question;
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//	
//	private void getListQuestion() {
//		Random random= new Random();
//		try {
//			int count = countQuestion();
//			
//			for(int i= 0; i<= 9; i++) {
//				long index= random.nextInt(count);
//				MCQuestionWrapper questionWrapper= questionWrapperRepository.findOne(index);
//				cache.insertQuestion(questionWrapper.getQuestion());
//			}
//		} catch (Exception e) {
//			throw e;
//		}
//	}
//	
//	protected int countQuestion() {
//		int count = 0;
//		try {
//			count= questionWrapperRepository.countQuestionById();
//			
//		} catch (Exception e) {
//			throw e;
//		}
//		return count;
//	}
}
