package com.judefrie.gamedatabase.driver;

import com.judefrie.gamedatabase.database.LoadGameDatabase;

import java.util.Scanner;

/**
 * Created by JudeFrie on 08/08/2014.
 */
public class Startup extends Throwable {

    int input;
    String username;
    String password;
    String passwordCheck;
    Scanner scan;
    NumberFormatException problem;

    public Startup() {
        input = 1;
        scan = new Scanner(System.in);
        problem = new NumberFormatException("Incorrect input");

        while (input != 0) {
            System.out.println("Would you like to:\n1 - Login \n2 - Create an account\nPress 0 to quit");
            try {
                input = scan.nextInt();
                if (input != 0 && input != 1 && input != 2)
                    throw problem;
            } catch (Exception e) {
                System.out.println("Incorrect input");
            }
            if (input == 1) {
                System.out.println("Please enter your username and password.");
                System.out.print("Username: ");
                username = scan.next();
                System.out.print("Password: ");
                password = scan.next();
                LoadGameDatabase loadGameDatabase = new LoadGameDatabase(username, password);

                // compare username and password to username and password in database
                break;

            } else if (input == 2) {
                System.out.println("Please enter a new user name and password.");
                System.out.print("Username: ");
                username = scan.next();
                System.out.print("Password: ");
                password = scan.next();
                System.out.print("Re-enter password: ");
                passwordCheck = scan.next();
                if (password.equals(passwordCheck)) {
                    ; // check to see if username already exists in database
                    // create new username and password in database
                    break;
                } else {
                    System.out.println("The password did not match the previous please try again.");
                    System.out.println("");
                }
            }
        }
    }
}
