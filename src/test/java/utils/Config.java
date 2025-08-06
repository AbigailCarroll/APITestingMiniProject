package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

    public class Config {
        private static final Properties properties = new Properties();

        static {
            try (InputStream stream = Config.class
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
            return properties.getProperty("automationexcercise.base_uri");
        }

        public static String getBrandsListUri() {
            return properties.getProperty("automationexcercise.api_path.get_all");
        }
    }

