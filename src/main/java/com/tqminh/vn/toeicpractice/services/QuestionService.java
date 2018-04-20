package com.tqminh.vn.toeicpractice.services;

import java.sql.SQLException;
import java.text.ParseException;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

public interface QuestionService<T extends AbstractQuestion> {

    int countQuestion();

    void deleteQuestion(long id, String username) throws SQLException;

    T findQuestion(String username, long id);

    T getQuestion(String username, int index) throws Exception;

    void insertQuestion(T question) throws NullPointerException, SQLException;

    int nextQuestion(String username) throws Exception;

    int previousQuestion(String username) throws Exception;

    void submit(String username) throws ParseException, SQLException;

    void updateQuestion(long id, AbstractQuestion question, String username)
            throws SQLException;

    void validateQuestion(
        String username,
        AbstractQuestion question,
        String selection) throws Exception;
}
