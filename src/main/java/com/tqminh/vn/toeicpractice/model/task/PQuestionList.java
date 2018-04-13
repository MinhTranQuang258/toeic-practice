package com.tqminh.vn.toeicpractice.model.task;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.PhotoQuestion;


public class PQuestionList extends AbstractQuestionList{
	
	private int concurrentIndex;
	
	private double score;
	
	private List<PhotoQuestion> questions;

	public PQuestionList() {
		super();
	}
	
	public PQuestionList(List<PhotoQuestion> questions) {
		super();
		this.questions = questions;
	}

	public List<PhotoQuestion> getQuestions() {
		return questions;
	}

	public int getConcurrentIndex() {
		return concurrentIndex;
	}

	public void setConcurrentIndex(int concurrentIndex) {
		this.concurrentIndex = concurrentIndex;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
