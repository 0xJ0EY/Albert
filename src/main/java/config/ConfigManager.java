package config;

import config.strategy.IniStrategy;

import java.io.*;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.HashMap;

/*
 * This class is meant for managing everything the config class uses
 * This includes actions like copying .env files and creating the root folder
 */
public class ConfigManager {

    private final String ROOT = System.getProperty("user.home") + File.separator + ".albert" + File.separator;
    private final String ENV_DIRECTORY = "/env/";

    private Config config;

    public ConfigManager(Config config) {
        this.config = config;
    }

    public void initialize() {

        // Check if the root folder exists
        if ( ! this.rootExists())
            this.createRoot();

        // Copy .env files
        this.copyEnvFiles();

        // Load config files
        this.loadConfigFiles();

    }

    private boolean rootExists() {
        return new File(ROOT).exists();
    }

    private boolean createRoot() {
        return new File(ROOT).mkdir();
    }

    private void copyEnvFiles() {

        HashMap<String, File> envs = this.listEnvFiles();
        HashMap<String, File> cnfs = this.listConfigFiles();

        for (String env : envs.keySet()) {
            // Remove the .env from the filename
            String cnf = this.toConfigName(env);

            // If the config file doesn't exists, we can copy it
            if (cnfs.get(cnf) == null) {
                this.copyEnvFile(envs.get(env));
            }
        }
    }

    private HashMap<String, File> listEnvFiles() {
        URL url = getClass().getResource(ENV_DIRECTORY);
        String path = url.getPath();

        HashMap<String, File> map = new HashMap<>();
        File[] files = new File(path).listFiles();

        if (files == null || files.length == 0) return map;

        for (File file : files) {
            map.put(file.getName(), file);
        }

        return map;
    }

    private HashMap<String, File> listConfigFiles() {
        HashMap<String, File> map = new HashMap<>();
        File[] files = new File(ROOT).listFiles();

        if (files == null || files.length == 0) return map;

        for (File file : files) {
            map.put(file.getName(), file);
        }

        return map;
    }

    private void copyEnvFile(File source) {
        String configName = toConfigName(source.getName());
        File dest = new File(ROOT + configName);

        FileChannel sourceChannel = null;
        FileChannel destChannel = null;

        try {
            try {
                sourceChannel = new FileInputStream(source).getChannel();
                destChannel = new FileOutputStream(dest).getChannel();

                destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());

            } finally {
                if (sourceChannel != null) sourceChannel.close();
                if (destChannel != null) destChannel.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void loadConfigFiles() {

        // TODO: Auto import via factory?
        IniStrategy iniStrategy = new IniStrategy();

        iniStrategy.load(ROOT, "config.ini");

        this.config.addConfig(iniStrategy, "config");
    }

    private String toConfigName(String env) {
        if (env.endsWith(".env")) {
            return env.substring(0, env.length() - 4);
        }

        return env;
    }

    private String toEnvName(String config) {
        if ( ! config.endsWith(".env")) {
            return config + ".env";
        }

        return config;
    }

}
