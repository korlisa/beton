package ru.sfedu.betonZavod.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static ru.sfedu.betonZavod.Constants.Constants.FULL_PATH;
import static ru.sfedu.betonZavod.Main.CONFIG_PATH;

/**
 * Configuration utility. Allows to get configuration properties from the
 * default configuration file
 *
 * @author Boris Jmailov
 */
public class ConfigurationUtil {

    //    public static final String DEFAULT_CONFIG_PATH = "src/main/resources/config.properties";
    public static final Properties configuration = new Properties();

    /**
     * Hides default constructor
     *
     *
     */
    public ConfigurationUtil() {
    }

    public static Properties getConfiguration() throws IOException {
        if(configuration.isEmpty()){
            loadConfiguration();
        }
        return configuration;
    }

    /**
     * Loads configuration from <code>DEFAULT_CONFIG_PATH</code>
     * @throws IOException In case of the configuration file read failure
     */
    public static void loadConfiguration() throws IOException{
        FileInputStream in;
        try {
            in = new FileInputStream(CONFIG_PATH);
        } catch (FileNotFoundException e) {
            in = new FileInputStream(FULL_PATH);
        }

        try {
            configuration.load(in);
        } catch (IOException ex) {
            throw new IOException(ex);
        } finally{
            in.close();
        }
    }
    /**
     * Gets configuration entry value
     * @param key Entry key
     * @return Entry value by key
     * @throws IOException In case of the configuration file read failure
     */
    public static String getConfigurationEntry(String key) throws IOException{
        return getConfiguration().getProperty(key);
    }

}

