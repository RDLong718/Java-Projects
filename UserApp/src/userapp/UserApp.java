/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program reads in a User object from the User class and prints out the
 * user name and the password hint. It also prints an error message if the
 * username and password are the same. I attempted to catch the
 * FileNotFoundException.
 *
 * @author rdlon
 */
public class UserApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("users.data.txt"));

            User user;

            while (scanner.hasNext()) {

                // uses the read method in the User class to read in the data from the file.
                user = User.read(scanner);

                System.out.println(user.toString() + " hint: " + user.getHint());

                if (user.verifyPassword(user.getUsername())) {

                    System.out.println("*** Error the password should not be the "
                            + "same as the user name\n");
                } else {

                    System.out.println("OK -- the password is different than the user name\n");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("***Error*** File Not Found");
        }
    }

}
