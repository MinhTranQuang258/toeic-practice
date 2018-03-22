package com.tqminh.vn.toeicpractice.cache.impl;

import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.QuestionCache;
import com.tqminh.vn.toeicpractice.model.PhotoQuestion;

@Component("PQuestionCache")
public class PQuestionCacheImpl implements QuestionCache<PhotoQuestion>{

	@Override
	public void insertQuestion(PhotoQuestion question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PhotoQuestion getQuestion(int index) {
		// TODO Auto-generated method stub
		return null;
	}

}
