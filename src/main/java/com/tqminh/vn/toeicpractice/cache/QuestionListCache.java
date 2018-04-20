package com.tqminh.vn.toeicpractice.cache;

public interface QuestionListCache<T> {

    T getQuestionList(String username);

    Boolean isCheckUsername(String username);

    void putQuestionList(String username, T t);

    T removeQuestionList(String username);
}
