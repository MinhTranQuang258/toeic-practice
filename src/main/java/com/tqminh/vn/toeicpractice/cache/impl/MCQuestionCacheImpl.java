package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.QuestionCache;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;

@Component("MCQuestionCache")
public class MCQuestionCacheImpl implements QuestionCache<MultipleChoiceQuestion>{
	
	private List<MultipleChoiceQuestion> questions= new ArrayList<MultipleChoiceQuestion>();

	@Override
	public void insertQuestion(MultipleChoiceQuestion question) {
		questions.add(question);
	}

	@Override
	public MultipleChoiceQuestion getQuestion(int index) {
		return questions.get(index);
	}
}
