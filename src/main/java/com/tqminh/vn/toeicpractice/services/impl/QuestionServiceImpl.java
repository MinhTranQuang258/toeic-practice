package com.tqminh.vn.toeicpractice.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.tqminh.vn.toeicpractice.model.Question;
import com.tqminh.vn.toeicpractice.repositories.QuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.QuestionWrapper;
import com.tqminh.vn.toeicpractice.services.QuestionService;


public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionWrapperRepository questionWrapperRepository;

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
	public QuestionWrapper loadQuestion(long index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> getListQuestion() {
		List<Question> questions= new ArrayList<Question>();
		Random random= new Random();
		try {
			int count = countQuestion();
			
			for(int i= 0; i<= 9; i++) {
				int index= random.nextInt(count);
				QuestionWrapper questionWrapper= questionWrapperRepository.findQuestionByIndex(index);
				questions.add(questionWrapper.getQuestion());
			}
		} catch (Exception e) {
			throw e;
		}
		
		return questions;
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
