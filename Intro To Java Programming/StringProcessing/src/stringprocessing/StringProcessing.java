/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0 Description: Process a string using the String class. Finds the
 * sum of the numerical values of each character in th string and prints the
 * string backwards.
 */
package stringprocessing;

import java.util.Scanner;

public class StringProcessing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int sum = 0;

        System.out.println("What is your name? ");
        name = sc.nextLine();   //reads an entire line

        System.out.println("\nNice to me you " + name);

        System.out.printf("Your name spelled backwards is: ");
        for (int i = name.length() - 1; i >= 0; i--) {
            char c = name.charAt(i);
            System.out.printf("%c", c);
            if (Character.isLetter(c)) {
                sum += c;       //sum the letters
            }
        } // end for
        System.out.printf("\n\nThe sum of the letters are %d\n", sum);
    } // end main
}
