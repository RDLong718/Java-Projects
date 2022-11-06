/**
 *
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Finds all relatively prime pairs from 1 to 100 inclusive.
 * Relatively prime pairs are numbers that only 1 can be divided into both
 * numbers.
 */
package relativelyprimepairs;

public class RelativelyPrimePairs {

    public static void main(String[] args) {
        int first, second, divisor;
        boolean possiblyPrime;

        for (first = 1; first <= 100; first++) {
            for (second = 1; second <= 100; second++) {
                divisor = first;
                possiblyPrime = true;
                while (divisor >= 1 && possiblyPrime) {
                    if (first % divisor == 0) {
                        if (divisor == 1) {
                            System.out.printf("%d and %d are relatively prime.\n",
                                    first, second);
                        } else if (second % divisor == 0) {
                            System.out.printf("%d and %d are not relatively prime.\n",
                                    first, second);
                            possiblyPrime = false;
                        }
                    }
                    divisor--;
                } // end while

            } // end for ... second
        } // end for ... first
    } // end main  
} // end RalativelyPrimePairs
