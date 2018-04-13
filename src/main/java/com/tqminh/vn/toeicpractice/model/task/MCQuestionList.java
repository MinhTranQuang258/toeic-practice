package com.tqminh.vn.toeicpractice.model.task;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;

public class MCQuestionList extends AbstractQuestionList{
	
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
	
	@Override
    public List<? extends AbstractQuestion> getQuestions() {
        return questions;
    }

    public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
}
