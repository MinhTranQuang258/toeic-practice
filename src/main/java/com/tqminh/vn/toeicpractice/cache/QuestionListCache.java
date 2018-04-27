
package com.tqminh.vn.toeicpractice.cache;

/**
 * The Interface QuestionListCache.
 *
 * @param <T> the generic type
 */
public interface QuestionListCache<T> {

    /**
     * Gets the question list.
     *
     * @param username the username
     * @return the question list
     */
    T getQuestionList(String username);

    /**
     * Checks if is check username.
     *
     * @param username the username
     * @return the boolean
     */
    Boolean isCheckUsername(String username);

    /**
     * Put question list.
     *
     * @param username the username
     * @param t the t
     */
    void putQuestionList(String username, T t);

    /**
     * Removes the question list.
     *
     * @param username the username
     * @return the t
     */
    T removeQuestionList(String username);
}
