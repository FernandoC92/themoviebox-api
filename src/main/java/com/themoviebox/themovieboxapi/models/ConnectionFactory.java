package com.themoviebox.themovieboxapi.models;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    Connection connection;

    static Connection getConnect() {

        try {
            Properties prop = getProperties();
            final String url = prop.getProperty("database.url");
            final String user = prop.getProperty("database.user");
            final String password = prop.getProperty("database.password");

            return DriverManager.getConnection(url, user, password);
            
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);  
        }

    }

    private static Properties getProperties() throws IOException {
        Properties prop = new Properties();
        String path = "/application.properties";
        prop.load(ConnectionFactory.class.getResourceAsStream(path));
        return prop;
    }

}