/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 * Description: Finds the average of a list of numbers using the trailer method.
 */
package average1;

import java.util.Scanner;

public class Average1 {

    public static void main(String[] args) {
        int counter;
        double average, number, sum;

        Scanner sc = new Scanner(System.in);

        
        sum = 0;
        counter = 0;
        

        promptUser();
        number = sc.nextDouble();
        while (number >= 0) {
            ++counter;
            sum = sum + number;
            number = sc.nextDouble();
        } // end while
        average = sum / counter;
        System.out.printf("The average is : %.1f\n", average);

    } // end main

    // The promptUser method prompts the user for the required information
    public static void promptUser() {
        System.out.println("Please enter a number.");
        System.out.println("In order to stop enter a negative number.");
    } // end promptUser
}