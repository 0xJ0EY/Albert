package config;

import config.strategy.ConfigStrategy;

import java.util.HashMap;

public class Config {

    private static Config instance;

    private ConfigManager configManager = new ConfigManager(this);
    private HashMap<String, ConfigStrategy> configs = new HashMap<>();

    public static synchronized Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }

        return instance;
    }

    private Config() {
        this.configManager.initialize();

    }

    public void addConfig(ConfigStrategy config, String name) {
        this.configs.put(name, config);
    }

    public String fetch(String config, String key) {
        ConfigStrategy strategy = this.configs.get(config);

        if (strategy == null)
            throw new NullPointerException();

        try {
            return strategy.get(key);
        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    // Shorthand for fetch
    public static String get(String config, String key) {
        return Config.getInstance().fetch(config, key);
    }

}
