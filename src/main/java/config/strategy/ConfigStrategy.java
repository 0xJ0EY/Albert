package config.strategy;

import config.InvalidKeyException;

// TODO: Auto-generated Javadoc
/**
 * The Interface ConfigStrategy.
 * @author
 */
public interface ConfigStrategy {

    /**
     * Load.
     *
     * @param root the root
     * @param filename the filename
     */
    // Load a config file
    void load(String root, String filename);

    /**
     * Gets the.
     *
     * @param key the key
     * @return the string
     * @throws InvalidKeyException the invalid key exception
     */
    String get(String key) throws InvalidKeyException;

    /**
     * Creates the.
     *
     * @param key the key
     * @param value the value
     * @throws InvalidKeyException the invalid key exception
     */
    // Create a new key
    void create(String key, String value) throws InvalidKeyException;

    /**
     * Update.
     *
     * @param key the key
     * @param value the value
     * @throws InvalidKeyException the invalid key exception
     */
    // Update an existing key
    void update(String key, String value) throws InvalidKeyException;

    /**
     * Delete.
     *
     * @param key the key
     * @throws InvalidKeyException the invalid key exception
     */
    // Delete an existing key
    void delete(String key) throws InvalidKeyException;

}
