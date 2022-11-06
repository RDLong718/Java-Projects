/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Converts feet and inches to meters. Uses a call by value.
 */

package writeasmeters;

import java.util.Scanner;

public class WriteAsMeters {

    public static void main(String[] args) {
        int feet, inches;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two integers representing the number of feet");
        System.out.println("and the number of inches: ");
        feet = sc.nextInt();
        inches = sc.nextInt();

        writeAsMeters(feet, inches);

        System.out.printf("is the same as %d feet and %d inches.\n", feet, inches);
    }

    public static void writeAsMeters(int feet, int inches) {
        double meters;
        inches = 12 * feet + inches;
        meters = inches / 39.39;
        System.out.printf("%.2f meters ", meters);
    }
}
