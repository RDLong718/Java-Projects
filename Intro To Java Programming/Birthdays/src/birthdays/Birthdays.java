/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0 Description: Write a Java program....... Use the trailer method
 * to signal the end of data
 */
package birthdays;

import java.util.Scanner;

public class Birthdays {

    public static void main(String[] args) {
        double birthMonth, birthYear, currentMonth, currentYear, age;

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter your birth month, birth year as well as");
        System.out.println("the current month followed by the current year.");
        System.out.println("Enter four zeros to stop.");

        birthMonth = sc.nextDouble();
        while (birthMonth > 0) {
            birthYear = sc.nextDouble();
            currentMonth = sc.nextDouble();
            currentYear = sc.nextDouble();

            age = currentYear - birthYear + (currentMonth - birthMonth) / 12;

            System.out.printf("For %.0f and %.0f your age is %.1f%n%n",
                    birthMonth, birthYear, age);

            System.out.println("Please enter your birth month, birth year as well as");
            System.out.println("the current month followed by the current year.");
            System.out.println("Enter a zero to stop.");

            birthMonth = sc.nextDouble();

        }
    }

}
