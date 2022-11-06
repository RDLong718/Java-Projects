/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author rdlonG\g This is a version 0 of the Phonebook app
 */
public class Phonebook {

    public static void main(String[] args) throws IOException {

        /*  Given a list of contacts in a file (last name phone number), read them
 * in and let the user search for a contact's phone number.
         */
// declare the parallel arrays to store the data
        final int CAPACITY = 100;
        String[] lastNames = new String[CAPACITY];
        String[] firstNames = new String[CAPACITY];
        String[] names = new String[CAPACITY];
        String[] numbers = new String[CAPACITY];
        String selection;
        int numberOfLookups = 0;
        int numberOfReverseLookups = 0;
        final String filename = "phonebook.txt";
        
        
// call a method to fill in these arrays
        int numElts = read(filename, lastNames, firstNames, numbers);

        Scanner keyboard = new Scanner(System.in);
        // structured read loop
        System.out.print("lookup, reverse-lookup, quit (l/r/q)?");
        while (keyboard.hasNext()) {

            selection = keyboard.next();
            if (selection.equals("l")) {
                System.out.print(" last name? ");
                String lastName = keyboard.next();
                System.out.print("first name? ");
                String firstName = keyboard.next();
                String number = lookup(lastNames, firstNames, numbers, lastName, firstName, numElts);
                if (number.equals("")) {
                    System.out.println("-- Name not found\n");

                } else {
                    System.out.println(firstName + " " + lastName + "'s phone number is " + number + "\n");

                }
                numberOfLookups++;
                System.out.print("lookup, reverse-lookup, quit (l/r/q)?");
            }
            if (selection.equals("r")) {
                System.out.print(" phone number (nnn-nnn-nnnn)?");
                String number = keyboard.next();
                String phoneNumber = reverseLookup(lastNames, firstNames, numbers, number, numElts);
                if (phoneNumber.equals("")) {
                    System.out.println(" -- Phone number not found\n");
                }
                numberOfReverseLookups++;
                System.out.print("lookup, reverse-lookup, quit (l/r/q)?");
            }
            if (selection.equals("q")) {
                System.out.println(" \n" + numberOfLookups + " lookups performed\n" + numberOfReverseLookups + " reverse lookups performed");
                break;
            }

        }
        keyboard.close();
    }

    /**
     * lookup method allows user to look up a contact based on last name
     * performs a classic linear search
     *
     * @param LastNames -- first array of type String
     * @param numbers -- second array of type String
     * @param lastName -- String which is the name to look up
     * @param size -- size
     * @return String which is the phone number
     */
    public static String lookup(String[] lastNames, String[] firstNames, String[] numbers, String lastName, String firstName, int size) {

        for (int i = 0; i < size; i++) {
            if (lastNames[i].equalsIgnoreCase(lastName) && firstNames[i].equalsIgnoreCase(firstName)) // DO NOT USE == on Strings
            {
                return numbers[i]; // return corresponding phone number
            }
        }
        return ""; // If not found, method will return the empty String
    }

    /**
     * method read will read in data from a file into two parallel arrays.
     *
     * @param filename -- name of the file for input
     * @param lastNames -- first array of type String
     * @param firstNames -- first names array
     * @param numbers -- second array of type String
     * @return number of elements filled in the array
     */
    public static int read(String filename, String[] lastNames, String[] firstNames, String[] numbers)
            throws IOException {
        //File file = new File(filename);
        //Scanner inputFile = new Scanner(file);
        Scanner inputFile = new Scanner(new File(filename));
        // size is used as an index into the array, and it keeps track of the 
        // first empty loc in the array, which is in effect the number of elts in arr
        int size = 0;
        // read in values but MAKE SURE not to exceed capacity of arrays
        while (inputFile.hasNext()) {
            if (size == lastNames.length) {
                System.out.println("Phonebook capacity exceeded - increase size "
                        + "of underlying array");
                System.exit(1); // terminate running of pgm and signal error
            }
            // read in data
            lastNames[size] = inputFile.next();
            firstNames[size] = inputFile.next();
            numbers[size] = inputFile.next();
            size++;
        }
        inputFile.close();
        return size;
    }

    public static String reverseLookup(String[] lastNames, String[] firstNames, String[] numbers, String number, int size) {

        for (int i = 0; i < size; i++) {
            if (numbers[i].equalsIgnoreCase(number)) // DO NOT USE == on Strings
            {
                System.out.println(" " + number + " belongs to " + lastNames[i] + ", " + firstNames[i] + "\n");
                return numbers[i];

            }

        }
        return "";
    }
}
