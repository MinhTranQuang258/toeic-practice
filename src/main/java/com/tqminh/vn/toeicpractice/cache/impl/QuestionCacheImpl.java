package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.QuestionCache;
import com.tqminh.vn.toeicpractice.model.Question;

@Component
@Qualifier("QuestionCache")
public class QuestionCacheImpl implements QuestionCache<Question>{
	
	private List<Question> questions= new ArrayList<Question>();

	@Override
	public void insertQuestion(Question question) {
		questions.add(question);
	}
	
	
}
