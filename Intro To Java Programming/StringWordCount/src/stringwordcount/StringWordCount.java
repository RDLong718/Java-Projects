/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0 Description: StringWordCount returns the number of wors in a
 * string.
 */
package stringwordcount;

import java.util.Scanner;

public class StringWordCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string;

        System.out.println("Enter a string: ");
        string = sc.nextLine();   //reads an entire line

        System.out.printf("Word Count: %d\n", stringWordCount(string));
    } // end main

    // counts the words in a string
    public static int stringWordCount(String s) {
        int count = 0;

        int i = 0;
        while (i < s.length()) {
            while (i < s.length() && Character.isWhitespace(s.charAt(i))) {
                // skip whitespace
                i++;
            }
            if (i < s.length()) {
                // found a word
                count++;
                while (i < s.length() && !Character.isWhitespace(s.charAt(i))) {
                    // skip the word
                    i++;
                }
            } // end if
        }  // end while
        return count;
    } // end stringWordCount
}
