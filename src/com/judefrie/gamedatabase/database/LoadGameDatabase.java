package com.judefrie.gamedatabase.database;

import java.sql.*;

/**
 * Created by Tyler on 08/08/2014.
 */
public class LoadGameDatabase {
    static String user = null;
    static String pass = null;
    String mysqlUsername = "root";
    String mysqlPassword = "xxxxxxx";
    Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public LoadGameDatabase(String username, String password) {
        try {
            user = username;
            pass = password;
            readDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getUser() {
        return user;
    }

    public void setUser(String username) {
        user = username;
    }

    public static String getPass() {
        return pass;
    }

    public void setPassword(String passwor) {
        pass = passwor;
    }

    public void readDatabase() throws Exception {
        System.out.println("Starting readDatabase");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://24.71.246.14:3306/game_database?user=gamedatabase&password=test123");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM game_database.users");
            if (authentication(resultSet)) {
                System.out.println("Worked");
            } else {
                System.out.println("Username and password did not match!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean authentication(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String databaseUser = resultSet.getString("Username");
            String databasePassword = resultSet.getString("PASSWORD");
            if (user.equals(databaseUser) && pass.equals(databasePassword)) {
                return true;
            }
        }
        return false;
    }
}
