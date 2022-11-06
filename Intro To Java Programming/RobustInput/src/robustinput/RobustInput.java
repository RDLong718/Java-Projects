/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: This program illustrates how to insure robust input.
 */
package robustinput;

import java.util.Scanner;

public class RobustInput {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean okay;

        do {
            System.out.print("Enter a number: ");
            if (sc.hasNextDouble()) {
                okay = true;
            } else {
                okay = false;
                String word = sc.next();
                System.err.println(word + " is not a number");
            }
        } while (!okay);
        double x = sc.nextDouble();
        System.out.printf("The number you entered is: %f\n", x);
    }
}
