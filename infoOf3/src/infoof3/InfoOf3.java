/**
 * @author Rashad Long
 * @since 08-27-2020
 * @version 1.0
 *
 * Description: This program reads three numbers from the keyboard then prints
 * out some information about the relationships between the numbers. It calls on
 * methods to prompt the user. It then scans the inputs. It then calls on
 * methods to determine the following information: are all the numbers equal?
 * are two of the numbers equal? are none of the numbers equal? are the numbers
 * in ascending or descending order? are the numbers in strict ascending or
 * descending order. This program calls methods with boolean functions to find
 * the information. This program is a good way to familiarize myself with
 * boolean. I did not find this too difficult.
 */
package infoof3;

import java.util.Scanner;

public class InfoOf3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean allEqual,
                twoEqual,
                noneEqual,
                ascending,
                descending,
                strictAscending,
                strictDescending;

        promptUser1();

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        allEqual = allAreEqual(a, b, c);
        System.out.println("second number? third number? "
                + "allAreEqual: " + allEqual);

        twoEqual = twoAreEqual(a, b, c);
        System.out.println("twoAreEqual: " + twoEqual);

        noneEqual = noneAreEqual(a, b, c);
        System.out.println("noneAreEqual: " + noneEqual);

        ascending = areAscending(a, b, c);
        System.out.println("areAscending: " + ascending);

        descending = areDescending(a, b, c);
        System.out.println("areDescending: " + descending);

        strictAscending = strictlyAscending(a, b, c);
        System.out.println("strictlyAscending: " + strictAscending);

        strictDescending = strictlyDescending(a, b, c);
        System.out.print("strictlyDescending: " + strictDescending);

    } // end main

    // This method prompts the user for the first number.
    public static void promptUser1() {

        System.out.print("first number? ");
    } // end promptUser1

    /**
     * This method takes the integers and calculates if they are all equal. It
     * returns a boolean value.
     */
    public static boolean allAreEqual(int a, int b, int c) {
        boolean allEqual = false;
        if (a == b && a == c) {
            allEqual = true;
        }
        return allEqual;
    } // end allAreEqual

    /**
     * This method takes the integers and calculates if two are equal. It
     * returns a boolean value.
     */
    public static boolean twoAreEqual(int a, int b, int c) {
        boolean twoEqual = false;
        if (a == b || a == c || b == c) {
            twoEqual = true;
            if (a == b && a == c) {
                twoEqual = false;
            }
        }
        return twoEqual;
    } // end twoEqual

    /**
     * This method takes the integers and calculates if none are equal. It
     * returns a boolean value.
     */
    public static boolean noneAreEqual(int a, int b, int c) {
        boolean noneEqual = false;
        if (a != b && a != c && b != c) {
            noneEqual = true;
        }
        return noneEqual;
    }// end noneEqual

    /**
     * This method takes the integers and calculates if they are ascending It
     * returns a boolean value.
     */
    public static boolean areAscending(int a, int b, int c) {
        boolean ascending = false;
        if (a <= b && b <= c) {
            ascending = true;
        }
        return ascending;
    } // end areAscending

    /**
     * This method takes the integers and calculates if they are descending. It
     * returns a boolean value.
     */
    public static boolean areDescending(int a, int b, int c) {
        boolean descending = false;
        if (a >= b && b >= c) {
            descending = true;
        }
        return descending;
    } // end areDescending

    /**
     * This method takes the integers and calculates if they are strictly
     * ascending. It returns a boolean value.
     */
    public static boolean strictlyAscending(int a, int b, int c) {
        boolean strictAscending = false;
        if (a < b && b < c) {
            strictAscending = true;
        }
        return strictAscending;
    } // end strictlyAscending

    /**
     * This method takes the integers and calculates if they are strictly
     * descending. It returns a boolean value.
     */
    public static boolean strictlyDescending(int a, int b, int c) {
        boolean strictDescending = false;
        if (a > b && b > c) {
            strictDescending = true;
        }
        return strictDescending;
    } //end strictlyDescending
}
