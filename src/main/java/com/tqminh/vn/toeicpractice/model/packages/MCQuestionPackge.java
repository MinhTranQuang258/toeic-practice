package com.tqminh.vn.toeicpractice.model.packages;

import java.util.List;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;
import com.tqminh.vn.toeicpractice.model.MultipleChoiceQuestion;

public class MCQuestionPackge extends AbstractQuestionPackage {

    private int concurrentIndex;

    private List<MultipleChoiceQuestion> questions;

    private double score;

    public MCQuestionPackge() {
        super();
    }

    public MCQuestionPackge(final int concurrentIndex,
            final List<MultipleChoiceQuestion> questions) {
        super();
        this.concurrentIndex = concurrentIndex;
        this.questions = questions;
    }

    public MCQuestionPackge(final List<MultipleChoiceQuestion> questions) {
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
