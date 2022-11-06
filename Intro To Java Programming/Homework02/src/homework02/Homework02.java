/**
 * @author Rashad Long
 * @since 07-25-2020
 * @version 10.0
 *
 * Description: This program reads the "MiserCorp.txt" file. The file contains
 * an unknown number of employee data records. Each group of data contains the
 * employee's last name, first name, hours worked, rate of pay and age. This
 * program prints that data. It then computes and prints each employee's base
 * pay, including overtime (paid at one and a half times the normal rate) for
 * each hour over 40. This program calls on the "computeTax" method. The
 * "computeTax" method receives the employee's age and the base pay. It returns
 * the appropriate tax. The program then prints the tax and net pay after taxes.
 * The program repeats this process until the last employee is read. After
 * reading all the information, the program prints the age and name of the
 * oldest employee. It does the same for the youngest. After all the results
 * have been printed, the program prints a message saying that the payroll
 * program is complete. I chose to have the program print all outputs to the
 * screen as well as to the "Homework02output.txt" file. The beginning of the
 * program was not difficult, however getting the program to print the youngest
 * and oldest was very difficult. I looked over the "FindLargest" handout and I
 * figured it out. I also looked online. I was having initialization issues with
 * the "oldestAge" and "youngestAge" so I googled it and discovered
 * "Integer.MAX_Value" and "Integer.MIN_Value". After that I was good to go.
 */
package homework02;

import java.util.Scanner;

import java.io.File;

import java.io.PrintStream;

public class Homework02 {

    public static void main(String[] args) throws Exception {

        int age,
                // The MIN and MAX functions intiatialize the 
                // variables.
                oldestAge = Integer.MIN_VALUE,
                youngestAge = Integer.MAX_VALUE;

        double hoursWorked,
                taxAmount,
                netPay,
                rateOfPay,
                basePay = Double.MIN_VALUE;

        // These are the string intitializations for the youngest 
        // and oldest. 
        String oldestFirstName = "firstName";
        String oldestLastName = "lastName";
        String youngestFirstName = "firstName";
        String youngestLastName = "lastName";

        // The "misercorp.txt" file is what the scanner reads 
        // data from.
        Scanner scanner = new Scanner(new File("misercorp.txt"));

        // All outputs also go to the "output.txt" file.
        PrintStream ps = new PrintStream("Homework02output.txt");

        System.out.println("\t\t\t\tMiser Corporation Payroll");

        ps.println("\t\t\t\tMiser Corporation Payroll");

        // This "while" loop reads via the scanner as long as 
        // there is more data. When the data finishes, the loop 
        // stops and prints specified results. 
        while (scanner.hasNext()) {
            String lastName = scanner.next();
            String firstName = scanner.next();
            hoursWorked = scanner.nextDouble();
            rateOfPay = scanner.nextDouble();
            age = scanner.nextInt();

            // This "if" statement begins the process of 
            // determining "basePay" including overtime.
            if (hoursWorked > 40) {
                basePay = (40 * rateOfPay) + ((hoursWorked - 40)
                        * (rateOfPay * 1.5));
            } else if (hoursWorked <= 40) {
                basePay = (hoursWorked * rateOfPay);
            }

            // This "if" statement determines who is the oldest.
            if (age > oldestAge) {
                oldestAge = age;
                oldestFirstName = firstName;
                oldestLastName = lastName;
            }

            // This "if" statement determines who is the youngest.
            if (age < youngestAge) {
                youngestAge = age;
                youngestFirstName = firstName;
                youngestLastName = lastName;
            }

            // This calls on the "computeTax" method which 
            // returns the appropriate tax.
            taxAmount = computeTax(age, basePay);

            // This uses the return from the "computeTax" method 
            // to calculate "netPay".            
            netPay = basePay - taxAmount;

            System.out.printf("\nThe employee's name is: %s %s "
                    + "whose age is %s years old.\n",
                    firstName, lastName, age);

            ps.printf("\nThe employee's name is: %s %s whose age "
                    + "is %s years old.\n", firstName, lastName, age);

            System.out.printf("The employee worked %.1f hours and "
                    + "earns $%.2f/hour.\n", hoursWorked, rateOfPay);

            ps.printf("The employee worked %.1f hours and earns "
                    + "$%.2f/hour.\n", hoursWorked, rateOfPay);

            System.out.printf("The base pay is $%.2f and the tax is "
                    + "$%.2f.\n", basePay, taxAmount);

            ps.printf("The base pay is $%.2f and the tax is "
                    + "$%.2f.\n", basePay, taxAmount);

            System.out.printf("The net pay is $%.2f.\n\n", netPay);

            ps.printf("The net pay is $%.2f.\n\n", netPay);

        }

        // These are outside the "while" loop so they do not repeat
        // after each scan. 
        System.out.printf("\nThe oldest employee was %s %s whose age "
                + "is %d years old.", oldestFirstName, oldestLastName,
                oldestAge);

        ps.printf("\nThe oldest employee was %s %s whose age is %d "
                + "years old.", oldestFirstName, oldestLastName,
                oldestAge);

        System.out.printf("\nThe youngest employee was %s %s whose age"
                + " is %d years old.", youngestFirstName,
                youngestLastName, youngestAge);

        ps.printf("\nThe youngest employee was %s %s whose age is %d "
                + "years old.", youngestFirstName,
                youngestLastName, youngestAge);

        // End of Program.
        System.out.println("\n\nThe payroll program is complete.");
        
        ps.println("\n\nThe payroll program is complete.");

    }

    // This "computeTax" method receives the employees age and the base 
    //pay. It then returns the appropriate tax.
    public static double computeTax(int age, double basePay) {
        double taxAmount;

        // This initializes the "taxAmount".
        taxAmount = Double.MIN_VALUE;

        // This "if" statement determines the tax amount based on the 
        // employees age.
        if (age >= 55) {
            taxAmount = basePay * .50;
        } else if (age < 55) {
            taxAmount = basePay * .10;
        }
        return taxAmount;

    }

}
