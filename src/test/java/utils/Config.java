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

        public static String getBaseUri()
        {
            return properties.getProperty("automationexercise.base_uri");
        }

        public static String getBrandsListUri() {
            return properties.getProperty("automationexercise.api_path.get_all_brands");
        }

        public static String getAllProductsUri()
        {
            return properties.getProperty("automationexercise.api_path.get_all_products");
        }

        public static String getAllUri()
        {
            return properties.getProperty("automationexercise.api_path.get_all");
        }

        public static String postAllProductsUri()
        {
            return properties.getProperty("automationexercise.api_path.post_all_products");
        }

        public static String getCreateAccountPath() {
            return properties.getProperty("automationexercise.api_path.create_account");
        }

        public static String getVerifyLoginPath() {
            return properties.getProperty("automationexercise.api_path.verify_login");
        }

        public static String getProperty(String key) {
            return properties.getProperty(key);
        }
    }

