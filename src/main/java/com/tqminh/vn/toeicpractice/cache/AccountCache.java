
package com.tqminh.vn.toeicpractice.cache;

/**
 * The Interface AccountCache.
 *
 * @param <T> the generic type
 */
public interface AccountCache<T> {

    /**
     * Gets the object.
     *
     * @param key the key
     * @return the object
     */
    T getObject(String key);

    /**
     * Gets the size.
     *
     * @return the size
     */
    int getSize();

    /**
     * Put.
     *
     * @param key the key
     * @param value the value
     */
    void put(String key, T value);

    /**
     * Removes the object.
     *
     * @param key the key
     */
    void removeObject(String key);
}
