package com.atm.new1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbConnection {
	
	
     public static Connection getConnection() {
    	 Properties properties = new Properties();
    	
    	 File file = new File("src\\com\\atm\\new1\\config.properties");
    	
         try (FileInputStream fileInput = new FileInputStream(file)) {
             properties.load(fileInput);
         } catch (IOException e) {
             e.printStackTrace();
         }
        
         String dbUrl = properties.getProperty("URL");
         String dbUsername = properties.getProperty("Uname");
         String dbPassword = properties.getProperty("password");

         System.out.println("Database URL: " + dbUrl);
         System.out.println("Database Username: " + dbUsername);
         System.out.println("Database Password: " + dbPassword);
    	 Connection connection = null;
    	 try {
    	 connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
     	} catch (SQLException e) {
			e.printStackTrace();
     		}

     		return connection;

	
}}



