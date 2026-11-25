package com.bank.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionUtil {
    public static Connection getConnection() throws SQLException {
        try (FileInputStream file = new FileInputStream("src/main/resources/application.properties")) {
            Properties props = new Properties();
            props.load(file);
            String url = props.getProperty("CONNECTION_URL");
            String user = props.getProperty("CONNECTION_USERNAME");
            String pass = props.getProperty("CONNECTION_PASSWORD");
            return DriverManager.getConnection(url, user, pass);

        } catch (IOException e) {
            System.out.println("Failed to load database properties file.");
            throw new RuntimeException("Could not read src/main/resources/application.properties. Copy the .example file and fill it in.");
        }
    }    
}
