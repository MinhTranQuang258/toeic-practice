package com.tqminh.vn.toeicpractice.services.impl;


import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.cache.QuestionCache;
import com.tqminh.vn.toeicpractice.model.Question;
import com.tqminh.vn.toeicpractice.repositories.QuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.QuestionWrapper;
import com.tqminh.vn.toeicpractice.services.AbstractQuestion;
import com.tqminh.vn.toeicpractice.services.QuestionService;

@Service
public class QuestionServiceImpl extends AbstractQuestion implements QuestionService{
	
	@Autowired
	private QuestionWrapperRepository questionWrapperRepository;
	
	@Autowired
	@Qualifier("QuestionCache")
	private QuestionCache<Question> cache;
	
	@Override
	public Question nextQuestion() {
		return super.nextQuestion();
	}

	@Override
	public Question previousQuestion() {
		return super.previousQuestion();
	}

	@Override
	public String insertQuestion(Question question) {
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
	public Question loadQuestion(long index) {
		// TODO Auto-generated method stub
		return null;
	}

	private void loadListQuestion() {
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
	public Question updateQuestion(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Question deleteQuestion(long id) {
		// TODO Auto-generated method stub
		return null;
	}	
}
