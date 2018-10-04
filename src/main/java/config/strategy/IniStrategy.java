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

        String[] parts = key.split("\\.", 2);

        if (parts.length < 2)
            throw new InvalidKeyException();

        String root = parts[0];
        String value = parts[1];

        return (String) this.config.get(root, value);
    }


    @Override
    public void create(String key, String value) {

    }

    @Override
    public void update(String key, String value) {

    }

    @Override
    public void delete(String key) {

    }
}
