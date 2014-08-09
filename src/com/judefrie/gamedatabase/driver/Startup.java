package com.judefrie.gamedatabase.driver;
import java.util.Scanner;

/**
 * Created by JudeFrie on 08/08/2014.
 */
public class Startup {
    String input;
    String username;
    String password;
    String passwordCheck;
    Scanner scan;

    public Startup() {
        scan = new Scanner(System.in);

        System.out.println("Would you like to:\n1 - Login \n2 - Create an account");
        input = scan.next();

        if (input == "1") {
            System.out.println("Please enter your username and password.");
            username = scan.next();
            password = scan.next();
        }

        else if (input == "2") {
            System.out.println("Please enter a new user name and password.");
            username = scan.next();
            password = scan.next();
            System.out.println("Re-enter password");
            passwordCheck = scan.next();
            if (password.equals(passwordCheck))
                ;
            else
                System.out.println("Password does not match previous");

        }

        else
            System.out.println("Incorrect input");
    }

}
