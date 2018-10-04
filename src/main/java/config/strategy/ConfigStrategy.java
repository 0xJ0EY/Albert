package config.strategy;

import config.InvalidKeyException;

public interface ConfigStrategy {

    // Load a config file
    void load(String root, String filename);

    String get(String key) throws InvalidKeyException;

    // Create a new key
    void create(String key, String value);

    // Update an existing key
    void update(String key, String value);

    // Delete an existing key
    void delete(String key);

}
