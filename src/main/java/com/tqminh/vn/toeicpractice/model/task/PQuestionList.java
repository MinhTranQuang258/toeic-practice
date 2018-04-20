package com.tqminh.vn.toeicpractice.model.task;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.PhotoQuestion;

public class PQuestionList extends AbstractQuestionList {

    private int concurrentIndex;

    private List<PhotoQuestion> questions;

    private double score;

    public PQuestionList() {
        super();
    }

    public PQuestionList(final List<PhotoQuestion> questions) {
        super();
        this.questions = questions;
    }

    @Override
    public int getConcurrentIndex() {
        return this.concurrentIndex;
    }

    @Override
    public List<PhotoQuestion> getQuestions() {
        return this.questions;
    }

    @Override
    public double getScore() {
        return this.score;
    }

    public void setConcurrentIndex(final int concurrentIndex) {
        this.concurrentIndex = concurrentIndex;
    }

    @Override
    public void setScore(final double score) {
        this.score = score;
    }
}
