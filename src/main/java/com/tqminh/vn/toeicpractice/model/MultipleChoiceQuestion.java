package com.tqminh.vn.toeicpractice.model;

public class MultipleChoiceQuestion extends AbstractQuestion {

    private String answerA;

    private String answerB;

    private String answerC;

    private String answerD;

    private String answerTrue;

    private String detailQuestion;

    public MultipleChoiceQuestion() {
        super();
    }

    public MultipleChoiceQuestion(final String detailQuestion,
            final String answerA, final String answerB, final String answerC,
            final String answerD, final String answerTrue) {
        super();
        this.detailQuestion = detailQuestion;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.answerTrue = answerTrue;
    }

    @Override
    public String getAnswerA() {
        return this.answerA;
    }

    @Override
    public String getAnswerB() {
        return this.answerB;
    }

    @Override
    public String getAnswerC() {
        return this.answerC;
    }

    @Override
    public String getAnswerD() {
        return this.answerD;
    }

    @Override
    public String getAnswerTrue() {
        return this.answerTrue;
    }

    @Override
    public String getDetailQuestion() {
        return this.detailQuestion;
    }

    public void setAnswerA(final String answerA) {
        this.answerA = answerA;
    }

    public void setAnswerB(final String answerB) {
        this.answerB = answerB;
    }

    public void setAnswerC(final String answerC) {
        this.answerC = answerC;
    }

    public void setAnswerD(final String answerD) {
        this.answerD = answerD;
    }

    public void setAnswerTrue(final String answerTrue) {
        this.answerTrue = answerTrue;
    }

    public void setDetailQuestion(final String detailQuestion) {
        this.detailQuestion = detailQuestion;
    }

}
