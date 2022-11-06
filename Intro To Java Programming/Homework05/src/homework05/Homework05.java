/**
 * @author Rashad Long
 * @since 08-12-2020
 * @version 1.0
 *
 * Description: This program reads text from file 
 * "catinhat.txt". It prints the text 10 words per 
 * line. It then counts and prints (in alphabetical order) 
 * the number of times each letter of the alphabet appears
 * in the text. It then counts and prints the number of 
 * words in the text. It also counts and prints the number 
 * of words of each size (i.e. number of 1 letter words, 
 * number of 2 letter words, number of 3 letter words, etc). 
 * Finally the program sorts and prints the frequency of 
 * occurrences of each letter in increasing order. This was 
 * by far the most difficult assignment for me. I am not 
 * comfortable with arrays as of yet. I definitely need to 
 * invest some more time in grasping the concepts of arrays. 
 * I will go over the lectures and the workbook again. I was
 * able to get 4 out of the 5 results I was looking for. 
 * The sorting by frequency occurrence proved to be too 
 * difficult for me. I will continue to work on it and 
 * hopefully I will be able to figure it out.
 */

package homework05;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class Homework05 {

    public static final int NUMBEROFLETTERS = 26;
    public static ps;final int NUMBEROFWORDS = 10;
    public static final int TOTALWORDS = 500;
    static PrintStream ps;

    public static void main(String[] args) throws Exception {

        int[] count = new int[NUMBEROFLETTERS];
        int[] textSize = new int[NUMBEROFWORDS];
        int wordCount = 0;
        char character;
        String text;

        Scanner scanner = new Scanner(new File("catinhat.txt"));
        ps = new PrintStream("Output.txt");

        while (scanner.hasNext()) {
            text = scanner.next();
            textSize[text.length()]++;

            for (int i = 0; i < text.length(); i++) {
                character = text.charAt(i);
                if (Character.isLetter(character)) {
                    count[(int) (Character.toUpperCase
        (character) - 'A')]++;
                }
            }
            if (wordCount++ % NUMBEROFWORDS == 0) {
                System.out.println();
                
                ps.println();
                
            }

            System.out.printf("%s ", text);

            ps.printf("%s ", text);

        }

        System.out.println("\n\nThe following is the "
                + "occurences of each letter in the text.\n");

        ps.println("\n\nThe following is the occurences "
                + "of each letter in the text.\n");

        for (int i = 0; i < NUMBEROFLETTERS; i++) {

            System.out.printf("%c = %d\n", (char) 
                    ('A' + i), count[i]);

            ps.printf("%c = %d\n", (char) ('A' + i), count[i]);
             
        }
    
        
        System.out.printf("\nNumber of words:\t%d\n", wordCount);

        ps.printf("\nNumber of words:\t%d\n", wordCount);

        printAndGraphResults(textSize);
        
    }

    /**
     * This method takes the textSize and prints and graphs
     * the results.
     */
    public static void printAndGraphResults(int[] count) {

        System.out.println("\nWord Letter Length\tCount");

        ps.println("\nWord Letter Length\tCount");

        for (int i = 1; i < NUMBEROFWORDS; i++) {

            System.out.printf("%18d%11d\n", i, count[i]);

            ps.printf("%18d%11d\n", i, count[i]);

        } 
    } 
    
}
