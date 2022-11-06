/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Determines whether a year is a leap year or not.
 */
package isleap;

import java.util.Scanner;

public class IsLeap {

    public static void main(String[] args) {
        int year;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a year: ");
        year = sc.nextInt();

        if (isLeap(year)) {
            System.out.printf("%d is a leap year\n", year);
        } else {
            System.out.printf("%d is a not a leap year\n", year);
        }
    }

    // isLeap is a boolean method
    public static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
