package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.QuestionCache;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;

@Component
@Qualifier("QuestionCache")
public class QuestionCacheImpl implements QuestionCache<MultipleChoiceQuestion>{
	
	private List<MultipleChoiceQuestion> questions= new ArrayList<MultipleChoiceQuestion>();

	@Override
	public void insertQuestion(MultipleChoiceQuestion question) {
		questions.add(question);
	}
	
	
}
