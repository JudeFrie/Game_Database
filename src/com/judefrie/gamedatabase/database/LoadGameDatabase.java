package com.judefrie.gamedatabase.database;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Tyler on 08/08/2014.
 */
public class LoadGameDatabase {
    static String user = null;
    static String password = null;
    String mysqlUsername = "root";
    String mysqlPassword = "Poopienerf1";
    Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public static boolean authentication(String user1, String pass1) {
        if (user1.equals(getUser()) && pass1.equals(getPass()))
            return true;
        else {
            System.out.println("They did not match the database");
            return false;
        }
    }

    public static String getUser() {
        return user;
    }

    public void setUser(String username) {
        user = username;
    }

    public static String getPass() {
        return password;
    }

    public void readDatabase() throws Exception {
        System.out.println("Starting readDatabase");
        try {
            System.out.println("reading class...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("assigning connection");
            connection = DriverManager.getConnection("jdbc:mysql://24.71.246.14:3306/game_database?" + "user=" + mysqlUsername + "&password=" + mysqlPassword);
            System.out.println("Creating statement...");
            statement = connection.createStatement();
            System.out.println("Executing statement");
            resultSet = statement.executeQuery("SELECT * FROM users");
            System.out.println("Showing statement...");
//            writeResultSet(resultSet);
            String user = resultSet.getString("Username");
            String password = resultSet.getString("PASSWORD");
        } catch (Exception e) {
            System.out.println("Problem:");
            throw e;
        } finally {
            close();
        }
    }

    private void close() {
        close((Closeable) resultSet);
        close((Closeable) statement);
        close((Closeable) connection);
    }

    private void close(Closeable c) {
        try {
            if (c != null) {
                c.close();
            }
        } catch (Exception e) {
            System.out.println("Could not close");
        }
    }

    public void setPassword(String password) {
        LoadGameDatabase.password = password;
    }

}
