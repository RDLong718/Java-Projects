/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Process a file as follows: 
 * 1.	Input one word at a time 
 * 2.	Count the number of words and letter 
 * 3.	Change lowercase letters to uppercase 
 * 4.   Printing three words on a line.
 */
package processwords;

import java.io.File;
import java.util.Scanner;

public class ProcessWords {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("sample.txt"));
        int wordCount = 0, letterCount = 0;
        final int NUMBEROFWORDSPERLINE = 3;

        while (sc.hasNext()) {
            String word = sc.next();
            word = word.toUpperCase();
            letterCount += word.length();
            if (wordCount++ % NUMBEROFWORDSPERLINE == 0) {
                System.out.println();
            }
            System.out.printf("%s ", word);
        } // end while
        System.out.printf("\n\nNumber of letters:\t%d\n", letterCount);
        System.out.printf("\nNumber of words:\t%d\n", wordCount);
    } // end main
} // end ProcessWords
