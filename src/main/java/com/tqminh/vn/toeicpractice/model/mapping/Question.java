package com.tqminh.vn.toeicpractice.model.mapping;

public class Question {

    private String answerA;

    private String answerB;

    private String answerC;

    private String answerD;

    private String answerTrue;

    private String detailQuestion;

    private int temporary;

    public String getAnswerA() {
        return this.answerA;
    }

    public String getAnswerB() {
        return this.answerB;
    }

    public String getAnswerC() {
        return this.answerC;
    }

    public String getAnswerD() {
        return this.answerD;
    }

    public String getAnswerTrue() {
        return this.answerTrue;
    }

    public String getDetailQuestion() {
        return this.detailQuestion;
    }

    public int getTemporary() {
        return this.temporary;
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

    public void setTemporary(final int temporary) {
        this.temporary = temporary;
    }
}
