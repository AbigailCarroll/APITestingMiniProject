package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ExerciseConfig {
    private static final Properties properties = new Properties();

    static {
        try (InputStream stream = ExerciseConfig.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (stream != null) {
                properties.load(stream);
            } else {
                throw new IOException("Unable to find config.properties");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getBaseUri() {
        return properties.getProperty("github.base_uri");
    }
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}