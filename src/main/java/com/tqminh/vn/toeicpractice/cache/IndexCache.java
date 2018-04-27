
package com.tqminh.vn.toeicpractice.cache;

import java.util.Set;

/**
 * The Interface IndexCache.
 *
 * @param <T> the generic type
 */
public interface IndexCache<T> {

    /**
     * Checks if is check index.
     *
     * @param username the username
     * @param index the index
     * @return true, if is check index
     */
    boolean isCheckIndex(String username, long index);

    /**
     * Removes the index.
     *
     * @param username the username
     */
    void removeIndex(String username);

    /**
     * Sets the index.
     *
     * @param username the username
     * @param set the set
     */
    void setIndex(String username, Set<T> set);
}
