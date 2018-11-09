package config.strategy;

import config.InvalidKeyException;
import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;

/**
 * The Class IniStrategy.
 *
 */
public class IniStrategy implements ConfigStrategy {

    /** The config. */
    private Ini config;

    /* (non-Javadoc)
     * @see config.strategy.ConfigStrategy#load(java.lang.String, java.lang.String)
     */
    @Override
    public void load(String root, String filename) {
        File file = new File(root + filename);

        try {
            this.config = new Ini(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /* (non-Javadoc)
     * @see config.strategy.ConfigStrategy#get(java.lang.String)
     */
    @Override
    public String get(String key) throws InvalidKeyException {

        String[] parts = this.parseKey(key);

        return (String) this.config.get(parts[0], parts[1]);
    }


    /* (non-Javadoc)
     * @see config.strategy.ConfigStrategy#create(java.lang.String, java.lang.String)
     */
    @Override
    public void create(String key, String value) throws InvalidKeyException {
        String[] parts = this.parseKey(key);

        this.config.put(parts[0], parts[1], value);
        this.save();
    }

    /* (non-Javadoc)
     * @see config.strategy.ConfigStrategy#update(java.lang.String, java.lang.String)
     */
    @Override
    public void update(String key, String value) throws InvalidKeyException {
        this.create(key, value);
    }

    /* (non-Javadoc)
     * @see config.strategy.ConfigStrategy#delete(java.lang.String)
     */
    @Override
    public void delete(String key) throws InvalidKeyException {
        String[] parts = this.parseKey(key);

        this.config.remove(parts[0], parts[1]);
        this.save();
    }

    /**
     * Parses the key.
     *
     * @param key the key
     * @return the string[]
     * @throws InvalidKeyException the invalid key exception
     */
    private String[] parseKey(String key) throws InvalidKeyException {

        String[] parts = key.split("\\.", 2);

        if (parts.length < 2)
            throw new InvalidKeyException();

        return parts;

    }

    /**
     * Save the config.
     */
    private void save() {
        try {
            this.config.store();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
