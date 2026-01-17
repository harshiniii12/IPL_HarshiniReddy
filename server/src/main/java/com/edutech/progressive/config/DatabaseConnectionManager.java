package com.edutech.progressive.config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
            if (in == null) in = new FileInputStream("src/main/resources/application.properties");
            properties.load(in);
            in.close();
            String driver = properties.getProperty("db.driver");
            if (driver != null && !driver.isBlank()) Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    public static Connection getConnection() {
        try {
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create DB connection", e);
        }
    }
}
