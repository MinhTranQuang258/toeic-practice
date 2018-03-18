package com.tqminh.vn.toeicpractice.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.repositories.MCQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.services.AbstractQuestion;
import com.tqminh.vn.toeicpractice.services.QuestionService;

@Service
public class MCQuestionServiceImpl extends AbstractQuestion<MultipleChoiceQuestion> implements QuestionService<MultipleChoiceQuestion>{

	@Autowired
	private MCQuestionWrapperRepository questionWrapperRepository;
	
	@Override
	public void nextQuestion() {
		super.nextQuestion();
	}

	@Override
	public void previousQuestion() {
		super.previousQuestion();
	}
	
	@Override
	public MultipleChoiceQuestion getQuestion(int index) {
		return super.getQuestion(index);
	}

	@Override
	public String insertQuestion(MultipleChoiceQuestion question) {
		try {
			if(question != null) {
				MCQuestionWrapper questionWrapper= new MCQuestionWrapper(question);
				MCQuestionWrapper wrapper= questionWrapperRepository.save(questionWrapper);
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
		return super.countQuestion();
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
