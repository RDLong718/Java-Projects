/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0 Description: Finds the average of a list of numbers using the
 * end of file method. method hasNext() checks to see if there are any more
 * values in the file.
 */
package average2;

import java.util.Scanner;

public class Average2 {

    public static void main(String[] args) {
        int counter;
        double average, number, sum;

        Scanner sc = new Scanner(System.in);

        counter = 0;
        sum = 0;

        promptUser();

        while (sc.hasNext()) {
            number = sc.nextDouble();
            ++counter;
            sum = sum + number;
            // number = sc.nextDouble();
        } // end while
        average = sum / counter;
        System.out.printf("The average is : %.1f\n", average);

    } // end main

    // The promptUser method prompts the user for the required information
    public static void promptUser() {
        System.out.println("Please enter a number.");
        System.out.println("In order to stop on Windows type <ctrl> z ");
        System.out.println("then press Enter. On other machines type <ctrl> d");
    } // end promptUser
}
