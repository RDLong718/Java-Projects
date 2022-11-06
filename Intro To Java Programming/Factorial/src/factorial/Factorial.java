/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0 Description: Calculates N!
 */
package factorial;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        int counter, n, product;

        Scanner sc = new Scanner(System.in);

        promptUser();
        n = sc.nextInt();
        while (n >= 0) {
            product = 1;
            for (counter = 1; counter <= n; counter++) {
                product = product * counter;
            }
            System.out.printf("\nN factorial is %d\n\n", product);
            promptUser();
            n = sc.nextInt();
        }
    }

    // The promptUser method prompts the user for the required information
    public static void promptUser() {
        System.out.println("Please enter a value for which you want to ");
        System.out.println("calculate the factorial.");
        System.out.println("Enter a negative number to stop.");
    }
}
