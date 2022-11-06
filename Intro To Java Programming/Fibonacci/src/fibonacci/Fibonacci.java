/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0 Description: This program calculates and prints all the
 * Fibonacci numbers less than or equal to 1000.
 */
package fibonacci;

public class Fibonacci {

    public static void main(String[] args) {
        int next, latest, sum;

        next = 0;
        latest = 1;

        System.out.printf("\n%d ", latest);
        sum = latest + next;
        while (sum <= 1000) {
            System.out.printf(" %d ", sum);
            next = latest;
            latest = sum;
            sum = latest + next;
        }
        
    }
}
