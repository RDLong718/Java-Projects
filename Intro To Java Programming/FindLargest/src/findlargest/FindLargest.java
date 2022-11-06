/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Finds the largest number in a list using the header method.
 */
package findlargest;

import java.util.Scanner;

public class FindLargest {

    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter the number of items in the list: ");
        n = sc.nextInt();

        System.out.printf("The largest number that was entered was: %.1f.\n",
                findLargest(n));
    } // end main

    // Method findLargest returns the largest number in the input.
    public static double findLargest(int n) {
        double number, largest;
        Scanner sc = new Scanner(System.in);

        System.out.println("\nEnter the first number; ");
        largest = sc.nextDouble();
        for (int i = 1; i < n; i++) {
            System.out.println("Next number; ");
            number = sc.nextDouble();
            if (number > largest) {
                largest = number;
            }
        }
        return largest;
    } // end method findLargest    
} // end class FindLarggest 