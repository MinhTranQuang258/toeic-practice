package com.tqminh.vn.toeicpractice.model.list;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;

public class MCQuestionList {
	
	private int concurrentIndex;
	
	private double score;
	
	private List<MultipleChoiceQuestion> questions;

	public int getConcurrentIndex() {
		return concurrentIndex;
	}

	public void setConcurrentIndex(int concurrentIndex) {
		this.concurrentIndex = concurrentIndex;
	}

	public MCQuestionList() {
		super();
	}
	
	public MCQuestionList(List<MultipleChoiceQuestion> questions) {
		super();
		this.questions = questions;
	}

	public MCQuestionList(int concurrentIndex, List<MultipleChoiceQuestion> questions) {
		super();
		this.concurrentIndex = concurrentIndex;
		this.questions = questions;
	}

	public List<MultipleChoiceQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<MultipleChoiceQuestion> questions) {
		this.questions = questions;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
