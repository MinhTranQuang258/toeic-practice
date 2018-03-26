package com.tqminh.vn.toeicpractice.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqminh.vn.toeicpractice.common.TypeDefinition;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;
import com.tqminh.vn.toeicpractice.repositories.MCQuestionWrapperRepository;
import com.tqminh.vn.toeicpractice.repositories.entities.MCQuestionWrapper;
import com.tqminh.vn.toeicpractice.services.AbstractQuestionService;
import com.tqminh.vn.toeicpractice.services.QuestionService;

@Service("MCQuestionService")
public class MCQuestionServiceImpl extends AbstractQuestionService implements QuestionService<MultipleChoiceQuestion>{

	@Override
	public void submit(String username) {
		super.submit(username, TypeDefinition.MULTIPLE_CHOICE_QUESTION);
	}

	@Autowired
	private MCQuestionWrapperRepository repository;
	
	@Override
	public int nextQuestion(String username) throws Exception {
		return super.nextQuestion(username, TypeDefinition.MULTIPLE_CHOICE_QUESTION);
	}

	@Override
	public int previousQuestion(String username) throws Exception {
		return super.previousQuestion(username, TypeDefinition.MULTIPLE_CHOICE_QUESTION);
	}
	
	@Override
	public MultipleChoiceQuestion getQuestion(int index) throws Exception {
		return (MultipleChoiceQuestion) super.getQuestion("admin", index, TypeDefinition.MULTIPLE_CHOICE_QUESTION);
	}

	@Override
	public String insertQuestion(MultipleChoiceQuestion question) {
		try {
			if(question != null) {
				MCQuestionWrapper questionWrapper= new MCQuestionWrapper(question);
				MCQuestionWrapper wrapper= repository.save(questionWrapper);
				if(wrapper == null) {
					throw new NullPointerException("Can't insert the mutilple-choice question.");
				}
			}
			else {
				throw new NullPointerException();
			}
		} catch (Exception e) {
			throw e;
		}
		return "";
	}
	
	@Override
	public int countQuestion() {
		return super.countQuestion(TypeDefinition.MULTIPLE_CHOICE_QUESTION);
	}

	@Override
	public double validateQuestion() {
		// TODO Auto-generated method stub
		return 0;
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
