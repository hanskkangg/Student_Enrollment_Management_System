/**
 * File Name: DbConnection.java
 * Student Name: Hans Kang, 040694631 
 * Professor: Gustavo
 * Due Date: March 4, 2024
 * Modified: March 4, 2024
 * Description: This class manages the database connection.
this class makes sure that only one connection to the database exists (Singleton pattern).

 * @author Hans Kang
 * @version 17.0.7
 * @since javaSE-17
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbConnection {
    private static Connection connection = null;

    private DbConnection() {}
    /**
     * Gets the single instance of the database connection. If it doesn't exist, it creates one.
     * 
     * @param url The database URL.
     * @param user The database user.
     * @param password The password for the user.
     * @return The single database connection instance.
     */
    public static Connection getConnection(String url, String user, String password) {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Database connection failed");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
