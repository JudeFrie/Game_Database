package com.judefrie.gamedatabase.driver;

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
        scan = new Scanner(System.in);
        problem = new NumberFormatException("Incorrect input");

        System.out.println("Would you like to:\n1 - Login \n2 - Create an account\nPress q to quit");
        try {
            input = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Wrong");
        }
        if (input == 1) {
            System.out.println("Please enter your username and password.");
            try {
                username = scan.next();
                password = scan.next();
            } catch (Exception e) {
                System.out.println("Wrong");
            }
        } else if (input == 2) {
            System.out.println("Please enter a new user name and password.");
            username = scan.next();
            password = scan.next();
            System.out.println("Re-enter password");
            passwordCheck = scan.next();
            if (password.equals(passwordCheck))
                ;
            else {
                try {
                    if (input != 1 || input != 2)
                        throw problem;
                } catch (Exception e) {
                    System.out.println("Password does not match previous");
                }
            }

        } else
            System.out.println("Incorrect input");
    }

}
