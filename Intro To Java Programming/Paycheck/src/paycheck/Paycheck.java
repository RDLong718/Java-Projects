/**
 * @author Rashad Long
 * @since   07-14-2020
 * @version 1.0
 * Description: This program takes the given number of hours worked and the rate
 * of pay and calculates the gross and net pay. 
 */

package paycheck;

import java.util.Scanner;

public class Paycheck {

    public static void main(String[] args) {
        final double TAXRATE = .15;
        double hours, rate, gross, net, totalTax;
        // I created a new bubble called totalTax in order to be able to
        // multiply the TAXRATE percentage by the gross
          

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the hours worked and the rate of pay: ");
        hours = sc.nextDouble();
        rate = sc.nextDouble();

        gross = hours * rate;
        totalTax = TAXRATE * gross;
        net = gross - totalTax;

        System.out.printf("The gross pay is: $%.2f%n", gross);
        System.out.printf("The net pay is: $%.2f%n", net);
    }
}
