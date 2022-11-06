/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework05c;

import java.io.File;
import java.util.Scanner;

public class Homework05C {

    public static final int NUMBEROFLETTERS = 26;
    public static final int NUMBEROFWORDS = 10;

    public static void main(String[] args) throws Exception {

        int[] count = new int[NUMBEROFLETTERS];
        int[] textSize = new int[NUMBEROFWORDS];
        int wordCount = 0;
        char character;
        String text;

        Scanner scanner = new Scanner(new File("sample.txt"));

        while (scanner.hasNext()) {
            text = scanner.next();
            textSize[text.length()]++;

            for (int i = 0; i < text.length(); i++) {
                character = text.charAt(i);
                if (Character.isLetter(character)) {
                    count[(int) (Character.toUpperCase(character) - 'A')]++;
                }
            }
            if (wordCount++ % NUMBEROFWORDS == 0) {
                System.out.println();
            }
            System.out.printf("%s ", text);

        }
        System.out.println("\n\nThe following is the occurences of each letter in the text.\n");
        for (int i = 0; i < NUMBEROFLETTERS; i++) {
            System.out.printf("%c = %d\n", (char) ('A' + i), count[i]);
        }
        System.out.printf("\nNumber of words:\t%d\n", wordCount);
        printAndGraphResults(textSize);
        bubbleSort(count, wordCount);
        System.out.println("The sorted letter count is:");
        for (int i = 0; i < wordCount; i++) {
            System.out.printf("%d\n", count[i]);
        }

    }

    /**
     * ***********************************************************************
     * Method printAndGraphResults prints and graphs the results.
     */
    public static void printAndGraphResults(int[] count) {
        System.out.println("\nWord Letter Length\tCount");

        for (int i = 1; i < NUMBEROFWORDS; i++) {
            System.out.printf("%18d%11d\n", i, count[i]);
        } // end for int i
    } // end printAndGraphResults

    public static void bubbleSort(int[] x, int n) {
        int hold, j, pass;
        boolean switched = true;

        for (pass = 0; pass < n - 1 && switched; pass++) {
            // outer loop controles the number of passes
            switched = false;       // initially no interchanges have been
            // made one this pass
            for (j = 0; j < n - pass - 1; j++) {
                // inner loop governs each individual pass
                if (x[j] > x[j + 1]) {
                    // elements are out of order an interhcange is necessary
                    switched = true;
                    hold = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = hold;
                } // end if
            } // end for (j = 0 ...
        } // end for (pass = 0 ...
    } // end bubbleSort method

}
