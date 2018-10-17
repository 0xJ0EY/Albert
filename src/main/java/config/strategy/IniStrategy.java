package config.strategy;

import config.InvalidKeyException;
import org.ini4j.Ini;

import java.io.File;
import java.io.IOException;

public class IniStrategy implements ConfigStrategy {

    private Ini config;

    @Override
    public void load(String root, String filename) {
        File file = new File(root + filename);

        try {
            this.config = new Ini(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String get(String key) throws InvalidKeyException {

        String[] parts = this.parseKey(key);

        return (String) this.config.get(parts[0], parts[1]);
    }


    @Override
    public void create(String key, String value) throws InvalidKeyException {
        String[] parts = this.parseKey(key);

        this.config.put(parts[0], parts[1], value);
        this.save();
    }

    @Override
    public void update(String key, String value) throws InvalidKeyException {
        this.create(key, value);
    }

    @Override
    public void delete(String key) throws InvalidKeyException {
        String[] parts = this.parseKey(key);

        this.config.remove(parts[0], parts[1]);
        this.save();
    }

    private String[] parseKey(String key) throws InvalidKeyException {

        String[] parts = key.split("\\.", 2);

        if (parts.length < 2)
            throw new InvalidKeyException();

        return parts;

    }

    private void save() {
        try {
            this.config.store();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
