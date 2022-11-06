/* @author Rashad Long
 * @since 08-18-2020
 * @version 1.0
 * Description: This program uses random number generation to 
 * create sentences. The program uses four arrays of String called 
 * article, noun, verb and preposition. The program creates a 
 * sentence by selecting a word at random from each array in the 
 * following order: article, noun, verb, preposition, article, noun.
 * As each word is picked, it prints separated by a single blank
 * from the previous word. Each sentence starts with a capital letter 
 * and ends with a period. The program generates a paragraph of twenty 
 * sentences. The arrays are filled from four text files. ("Article.txt",
 * "Noun.txt" "Verb.txt" "Preposition.txt")  
 */
package homework06;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class Homework06 {

    static PrintStream ps;

    public static void main(String[] args) throws Exception {

        ps = new PrintStream("Output2.txt");

        Scanner scannerNoun = new Scanner(new File("Noun2.txt"));
        Scanner scannerVerb = new Scanner(new File("Verb2.txt"));
        Scanner scannerArticle = new Scanner(new File("Article2.txt"));
        Scanner scannerPreposition = new Scanner(new File("Preposition2.txt"));

        int articleCount, nounCount, verbCount,
                prepositionCount, i, j, paragraphCounter;

        String[] article = new String[100];
        String[] noun = new String[100];
        String[] verb = new String[100];
        String[] preposition = new String[100];
        paragraphCounter = 0;

        articleCount = populateArray(article, scannerArticle);
        nounCount = populateArray(noun, scannerNoun);
        verbCount = populateArray(verb, scannerVerb);
        prepositionCount = populateArray(preposition,
                scannerPreposition);

        System.out.println("This is how the output "
                + "looks after adding the "
                + "additional words to the text files.\n\n");

        ps.println("This is how the output looks after"
                + " adding the "
                + "additional words to the text files.\n\n");

        // This produces 2 paragraphs of 5 random sentences
        for (j = 0; j < 2; j++) {
            //Provides the indentation of every pararapgh.
            System.out.print("\t");
            
            ps.print("\t");
            
            for (i = 0; i < 5; i++) {
                generateRandom(article, noun, verb, preposition,
                        articleCount, nounCount, verbCount,
                        prepositionCount);

            }

            System.out.println("\n");

            ps.println("\n");
        }
    }

    /* This method reads a string one at a time, places 
     * it into the next available slot of the array and returns 
     * the number of strings that were read.
     */
    public static int populateArray(String[] arr, Scanner sc)
            throws Exception {

        int i = 0;
        while (sc.hasNext()) {
            arr[i] = sc.next();
            i++;
        }
        return i;
    }

    /* This method takes the Strings(article, noun, verb, 
     * preopsition) and the counts of those strings and returns 
     * a random sentence.
     */
    public static void generateRandom(String[] article,
            String[] noun, String[] verb, String[] preposition,
            int articleCount, int nounCount, int verbCount,
            int prepositionCount) throws Exception {

        int randomArticle1 = (int) (Math.random() * articleCount);
        int randomNoun1 = (int) (Math.random() * nounCount);
        int randomVerb = (int) (Math.random() * verbCount);
        int randomPreposition = (int) (Math.random() * prepositionCount);
        int randomArticle2 = (int) (Math.random() * articleCount);
        int randomNoun2 = (int) (Math.random() * nounCount);

        String part1 = article[randomArticle1];
        String part2 = noun[randomNoun1];
        String part3 = verb[randomVerb];
        String part4 = preposition[randomPreposition];
        String part5 = article[randomArticle2];
        String part6 = noun[randomNoun2];

        part1 = part1.substring(0, 1).toUpperCase()
                + part1.substring(1);

        System.out.print(part1 + " " + part2 + " " + part3 + " "
                + part4 + " " + part5 + " " + part6 + ". ");

        ps.print(part1 + " " + part2 + " " + part3 + " " + part4
                + " " + part5 + " " + part6 + ". ");
    }

}
