/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Reads words from a file and lists the distribution of word
 * lengths
 */
package wordlengthfrequency;

import java.io.File;
import java.util.Scanner;

public class WordLengthFrequency {

    public static final int MAXIMUMLENGTH = 21;

    public static void main(String[] args) throws Exception {

        int[] count = new int[MAXIMUMLENGTH];

        readAndCount(count);
        printAndGraphResults(count);
    } // end main

    /**
     * ***********************************************************************
     * Method readAndCount reads and counts the word lengths.
     */
    public static void readAndCount(int[] count) throws Exception {
        Scanner sc = new Scanner(new File("sample.txt"));

        while (sc.hasNext()) {
            String word = sc.next();
            count[word.length()]++;
        }
    }// end readAndCount

    /**
     * ***********************************************************************
     * Method printAndGraphResults prints and graphs the results.
     */
    public static void printAndGraphResults(int[] count) {
        System.out.println("Length\tCount");

        for (int i = 1; i < MAXIMUMLENGTH; i++) {
            System.out.printf("%d\t%d\t", i, count[i]);

            for (int j = 1; j <= count[i]; j++) {
                System.out.print('*');
            }
            System.out.println();
        } // end for int i
    } // end printAndGraphResults
}

    

