package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    static Properties properties;

    static {

        try {

            properties = new Properties();

            FileInputStream file =
                    new FileInputStream(
                            "src/test/resources/config.properties");

            properties.load(file);

        }

        catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {

        if ("username".equals(key)) {

            String envUser =
                    System.getenv("BRANDNESS_USERNAME");

            if (envUser != null && !envUser.isEmpty()) {

                return envUser;
            }
        }

        if ("password".equals(key)) {

            String envPassword =
                    System.getenv("BRANDNESS_PASSWORD");

            if (envPassword != null && !envPassword.isEmpty()) {

                return envPassword;
            }
        }

        return properties.getProperty(key);
    }
}