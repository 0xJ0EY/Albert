package config.strategy;

import config.InvalidKeyException;

/**
 * The Interface ConfigStrategy.
 *
 */
public interface ConfigStrategy {

    /**
     * Load the key.
     *
     * @param root the root
     * @param filename the filename
     */
    // Load a config file
    void load(String root, String filename);

    /**
     * Gets the key.
     *
     * @param key the key
     * @return the string
     * @throws InvalidKeyException the invalid key exception
     */
    String get(String key) throws InvalidKeyException;

    /**
     * Create a new key
     *
     * @param key the key
     * @param value the value
     * @throws InvalidKeyException the invalid key exception
     */
    void create(String key, String value) throws InvalidKeyException;

    /**
     * Update an existing key.
     *
     * @param key the key
     * @param value the value
     * @throws InvalidKeyException the invalid key exception
     */
    void update(String key, String value) throws InvalidKeyException;

    /**
     * Delete an existing key.
     *
     * @param key the key
     * @throws InvalidKeyException the invalid key exception
     */
    void delete(String key) throws InvalidKeyException;

}
