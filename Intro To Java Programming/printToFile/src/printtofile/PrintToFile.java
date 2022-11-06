/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: This is my first program and is to be handed in. The results
 * will be sent to a file.
 */
package printtofile;

import java.io.PrintStream;         // import PrintStream class
import java.util.Scanner;

public class PrintToFile {

    public static void main(String[] args) throws Exception {
        String first, last;

        Scanner sc = new Scanner(System.in);

        // create a PrintSTream ps to which the output will be directed.
        PrintStream ps = new PrintStream("output.txt");

        System.out.println("Please enter your first and last name.");
        System.out.println("Do not forget to press the ENTER key.");

        first = sc.next();
        last = sc.next();

        // use ps instead of System.out
        ps.println("\nThis is my first program!");
        ps.println("My name is: " + first + " " + last);
    } // end main
} // end PrintToFile