package com.judefrie.gamedatabase.database;

import java.sql.Connection;

/**
 * Created by Tyler on 08/08/2014.
 */
public class LoadGameDatabase {
    Connection connection = null;

    public LoadGameDatabase(){
        try{
            System.out.println("Loading the game database");
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException e){
            System.err.println("There was an error finding the mysql driver");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
