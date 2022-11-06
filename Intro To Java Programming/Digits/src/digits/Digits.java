/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: The program determines the number of digits in a number
 */

package digits;

import java.util.Scanner;

public class Digits {

    public static void main(String[] args) {
        int inputNumber, numberOfDigits = 0;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter an integer: ");
        inputNumber = sc.nextInt();
        do {
            inputNumber /= 10;
            numberOfDigits++;
        } while (inputNumber != 0);
        System.out.printf("\nThe number has %d digits.\n", numberOfDigits);
        
       
    }
}
