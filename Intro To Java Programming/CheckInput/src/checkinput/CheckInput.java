/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: CheckInput prompts the used for an integer between a given lower
 * and upper range and allows the user to correct improperly entered data
 */
package checkinput;

import java.util.Scanner;

public class CheckInput {

    // main test the checkInput method
    public static void main(String[] args) {
        int lower, upper;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a lower and upper limit for your integer.\n");
        lower = sc.nextInt();
        upper = sc.nextInt();
        System.out.printf("\nThe number you entered was: %d\n",
                checkInput(lower, upper));
    }

    /* 
     * Method check input prompts the user for an integer between
     * a given lower and upper range and allows the user to correct 
     * improperly enterd data.
     */
    public static int checkInput(int lower, int upper) {
        int value;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.printf("\nEnter an integer between %d and %d:", lower, upper);
            value = sc.nextInt();
            if (value < lower) {
                System.out.println("\nToo small. Try again. ");
            } else if (value > upper) {
                System.out.println("\nToo large. Try again. ");
            }
        } while (value < lower || value > upper);
        return value;
    }
}
