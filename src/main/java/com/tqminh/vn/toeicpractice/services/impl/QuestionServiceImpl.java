package com.tqminh.vn.toeicpractice.services.impl;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.cache.QuestionCache;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.repositories.QuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.QuestionWrapper;
import com.tqminh.vn.toeicpractice.services.AbstractQuestion;
import com.tqminh.vn.toeicpractice.services.QuestionService;

@Service
public class QuestionServiceImpl extends AbstractQuestion<MultipleChoiceQuestion> implements QuestionService{
	
	@Override
	public void displayQuestion() {
		super.displayQuestion();
	}

	@Autowired
	private QuestionWrapperRepository questionWrapperRepository;
	
	@Autowired
	@Qualifier("QuestionCache")
	private QuestionCache<MultipleChoiceQuestion> cache;
	
	@Override
	public void nextQuestion() {
		super.nextQuestion();
	}

	@Override
	public void previousQuestion() {
		super.previousQuestion();
	}

	@Override
	public String insertQuestion(MultipleChoiceQuestion question) {
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
	public int countQuestion() {
		int count = 0;
		try {
			count= questionWrapperRepository.countQuestionById();
			
		} catch (Exception e) {
			throw e;
		}
		return count;
	}

	@Override
	public MultipleChoiceQuestion loadQuestion(int index) {
		try {
			getListQuestion();
			MultipleChoiceQuestion question=  cache.getQuestion(index);
			return question;
		} catch (Exception e) {
			throw e;
		}
	}

	private void getListQuestion() {
		Random random= new Random();
		try {
			int count = countQuestion();
			
			for(int i= 0; i<= 9; i++) {
				long index= random.nextInt(count);
				QuestionWrapper questionWrapper= questionWrapperRepository.findOne(index);
				cache.insertQuestion(questionWrapper.getQuestion());
			}
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public MultipleChoiceQuestion updateQuestion(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MultipleChoiceQuestion deleteQuestion(long id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
