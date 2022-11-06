/**
 * @author  Yedidyah Langsam
 * @since   11-06-2016
 * @version 1.0
 * Description:  Write a Java program.......using methods
 * Use the trailer method to signal the end of data
 * Illustrates the use of local and instance variables
 */

package birthdays3;

import java.util.Scanner;

public class Birthdays3 {
    
    public static double  currentMonth, currentYear;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        double birthMonth, birthYear, age;
     
        getDate();
        
        promptUser();
        birthMonth = sc.nextDouble();
        while (birthMonth > 0) {
            birthYear = sc.nextDouble();

            age = currentYear - birthYear + (currentMonth - birthMonth) / 12;

            System.out.printf("For %.0f and %.0f your age is %.1f%n%n", 
                    birthMonth, birthYear, age);

            promptUser();
            birthMonth = sc.nextDouble();

        }
    }

    
    // The promptUser method prompts the user for the required information
    public static void promptUser() {
        System.out.println("Please enter your birth month and birth year.");
        System.out.println("Enter a zero to stop.");
    }

    
    // Asks the user for today's date
    public static void getDate() {
        System.out.println("Enter the current month followed by the current year");
        currentMonth = sc.nextDouble();
        currentYear = sc.nextDouble();
    }

}
