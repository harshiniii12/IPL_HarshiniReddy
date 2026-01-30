package com.edutech.progressive.config;
 
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
 
public class DatabaseConnectionManager {
    private static Properties properties = new Properties();
 
    private static void loadProperties(){
        try (FileInputStream fs = new FileInputStream("src/main/resources/application.properties")) {
            properties.load(fs);
        } catch (Exception e) {
            throw new RuntimeException("Properties file not found or cannot be read", e);
        }
    }
    public static Connection getConnection(){
        try {
            if (properties.isEmpty()) {
                loadProperties();
            }
            String url = properties.getProperty("spring.datasource.url");
            String user = properties.getProperty("spring.datasource.username");
            String pass = properties.getProperty("spring.datasource.password");
            String driverClass = properties.getProperty("spring.datasource.driver-class-name");
 
            Class.forName(driverClass);
 
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create DB Connection", e);
        }
    }
 
}