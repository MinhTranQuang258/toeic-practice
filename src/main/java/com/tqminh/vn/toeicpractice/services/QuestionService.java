package com.tqminh.vn.toeicpractice.services;

import java.sql.SQLException;
import java.text.ParseException;

import com.tqminh.vn.toeicpractice.model.AbstractQuestion;

/**
 * The Interface QuestionService.
 *
 * @param <T> the generic type
 */
public interface QuestionService<T extends AbstractQuestion> {

    /**
     * Count question.
     *
     * @return the int
     */
    int countQuestion();

    /**
     * Delete question.
     *
     * @param id the id
     * @param username the username
     * @throws SQLException the SQL exception
     */
    void deleteQuestion(long id, String username) throws SQLException;

    /**
     * Find a question.
     *
     * @param username the username
     * @param id the id
     * @return the t
     */
    T findQuestion(String username, long id);

    /**
     * Gets the question.
     *
     * @param username the username
     * @param index the index
     * @return the question
     * @throws Exception the exception
     */
    T getQuestion(String username, int index) throws Exception;

    /**
     * Insert question.
     *
     * @param question the question
     * @throws NullPointerException the null pointer exception
     * @throws SQLException the SQL exception
     */
    void insertQuestion(T question) throws NullPointerException, SQLException;

    /**
     * Next question.
     *
     * @param username the username
     * @return the int
     * @throws Exception the exception
     */
    int nextQuestion(String username) throws Exception;

    /**
     * Previous question.
     *
     * @param username the username
     * @return the int
     * @throws Exception the exception
     */
    int previousQuestion(String username) throws Exception;

    /**
     * Submit.
     *
     * @param username the username
     * @throws ParseException the parse exception
     * @throws SQLException the SQL exception
     */
    void submit(String username) throws ParseException, SQLException;

    /**
     * Update question.
     *
     * @param id the id
     * @param question the question
     * @param username the username
     * @throws SQLException the SQL exception
     */
    void updateQuestion(long id, AbstractQuestion question, String username)
            throws SQLException;

    /**
     * Validate question.
     *
     * @param username the username
     * @param question the question
     * @param selection the selection
     * @throws Exception the exception
     */
    void validateQuestion(
        String username,
        AbstractQuestion question,
        String selection) throws Exception;
}
