package com.tqminh.vn.toeicpractice.model.task;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;

public class MCQuestionList extends AbstractQuestionList {

    private int concurrentIndex;

    private List<MultipleChoiceQuestion> questions;

    private double score;

    public MCQuestionList() {
        super();
    }

    public MCQuestionList(final int concurrentIndex,
            final List<MultipleChoiceQuestion> questions) {
        super();
        this.concurrentIndex = concurrentIndex;
        this.questions = questions;
    }

    public MCQuestionList(final List<MultipleChoiceQuestion> questions) {
        super();
        this.questions = questions;
    }

    @Override
    public int getConcurrentIndex() {
        return this.concurrentIndex;
    }

    @Override
    public List<? extends AbstractQuestion> getQuestions() {
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
