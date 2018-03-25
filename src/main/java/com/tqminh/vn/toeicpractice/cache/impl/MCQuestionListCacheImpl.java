package com.tqminh.vn.toeicpractice.cache.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.tqminh.vn.toeicpractice.cache.QuestionListCache;
import com.tqminh.vn.toeicpractice.model.list.MCQuestionList;

@Component("MCQuestionListCache")
public class MCQuestionListCacheImpl implements QuestionListCache<MCQuestionList>{

	private Map<String,MCQuestionList> map= new HashMap<>();

	@Override
	public void putQuestionList(String username, MCQuestionList mcQuestionList) {
		map.put(username, mcQuestionList);
	}

	@Override
	public MCQuestionList getQuestionList(String username) {
		return map.get(username);
	}

	@Override
	public MCQuestionList removeQuestionList(String username) {
		return map.remove(username);
	}

	@Override
	public Boolean isCheckUsername(String username) {
		return map.containsKey(username);
	}
}
