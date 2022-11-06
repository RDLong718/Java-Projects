/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userapp;

import java.util.Scanner;

/**
 *
 * @author rdlon
 */
public class User {

    private String username;
    private String password;
    private String passwordhint;

    /**
     * Constructor for the User object
     *
     * @param username
     * @param password
     * @param passwordhint
     */
    public User(String username, String password, String passwordhint) {
        this.username = username;
        this.password = password;
        this.passwordhint = passwordhint;
    }

    /**
     * Returns the username.
     *
     * @return
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * Returns the password hint
     *
     * @return
     */
    public String getHint() {
        return this.passwordhint;
    }

    /**
     * Verifies to make sure that the password is the same as the parameter
     *
     * @param a
     * @return
     */
    public boolean verifyPassword(String a) {
        return this.password.equals(a);
    }

    /**
     * This method returns the String of the username.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.username;
    }

    /**
     * Reads in data using the Scanner object and creates and returns a new User
     * object.
     *
     * @param scanner
     * @return
     */
    public static User read(Scanner scanner) {
        if (!scanner.hasNext()) {
            return null;
        }

        String username = scanner.next();
        String password = scanner.next();
        String passwordhint = scanner.next();

        return new User(username, password, passwordhint);
    }
}
