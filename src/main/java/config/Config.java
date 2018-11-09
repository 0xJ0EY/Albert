package config;

import config.strategy.ConfigStrategy;

import java.util.HashMap;

/**
 * The Class Config.
 *
 */
public class Config {

    /** The instance. */
    private static Config instance;

    /** The config manager. */
    private ConfigManager configManager = new ConfigManager(this);
    
    /** The configs. */
    private HashMap<String, ConfigStrategy> configs = new HashMap<>();

    /**
     * Gets the single instance of Config.
     *
     * @return single instance of Config
     */
    public static synchronized Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }

        return instance;
    }

    /**
     * Instantiates a new config.
     */
    private Config() {
        this.configManager.initialize();
    }

    /**
     * Adds the config.
     *
     * @param config the config
     * @param name the name
     */
    public void addConfig(ConfigStrategy config, String name) {
        this.configs.put(name, config);
    }

    /**
     * Fetch.
     *
     * @param config the config
     * @param key the key
     * @return the string
     */
    public String fetch(String config, String key) {
        ConfigStrategy strategy = this.configs.get(config);

        if (strategy == null)
            throw new NullPointerException("Strategy doesn't exists");

        try {
            return strategy.get(key);
        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * Gets the config.
     *
     * @param config the config
     * @param key the key
     * @return the string
     */
    // Shorthand for fetch
    public static String get(String config, String key) {
        return Config.getInstance().fetch(config, key);
    }

}
