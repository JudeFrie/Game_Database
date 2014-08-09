package com.judefrie.gamedatabase.database;

import java.io.Closeable;
import java.sql.*;

/**
 * Created by Tyler on 08/08/2014.
 */
public class LoadGameDatabase {
    String username = "root";
    String password = "Poopienerf1";
    Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;


    public void readDatabase() throws Exception {
        System.out.println("Starting readDatabase");
        try {
            System.out.println("reading class...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("assigning connection");
            connection = DriverManager.getConnection("jdbc:mysql://24.71.246.14:3306/game_database?" + "user="+username+"&password="+password);
            System.out.println("Creating statement...");
            statement = connection.createStatement();
            System.out.println("Executing statement");
            resultSet = statement.executeQuery("SELECT * FROM users");
            System.out.println("Showing statement...");
            writeResultSet(resultSet);
        } catch (Exception e){
            System.out.println("Problem:");
            throw e;
        } finally {
            close();
        }
    }

    public void writeResultSet(ResultSet resultset) throws SQLException {
        while(resultSet.next()){
            String user = resultSet.getString("Username");
            String password = resultSet.getString("PASSWORd");

            System.out.println("Username: "+user);
            System.out.println("Password: "+password);
        }
    }

    private void close(){
        close((Closeable) resultSet);
        close((Closeable) statement);
        close((Closeable) connection);
    }

    private void close(Closeable c){
        try{
            if(c != null){
                c.close();
            }
        } catch (Exception e){
            System.out.println("Could not close");
        }
    }
}
