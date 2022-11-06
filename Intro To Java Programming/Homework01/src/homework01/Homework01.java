/**
 * @author Rashad Long
 * @since 07-17-2020
 * @version 2.0
 *
 * Description: This program asks the user to input the number of half
 * dollars, quarters, dimes, nickels and pennies. It then uses that 
 * information to print out the number of each coin entered, the total
 * coins entered, and the value of those coins entered in both dollar
 * denominations and penny denominations. This program continues to 
 * retrieve information from the user until the user has no more coins, 
 * at which point the user answers all questions with a 0 and the 
 * program will stop. Creating the loop proved tricky because I decided 
 * to ask each question separately instead of together like in the 
 * birthday projects. I was confused as to where to put the "while" 
 * method. I played with it for a bit and it seemed to have worked out.
 */

package homework01;

import java.util.Scanner;
import java.io.PrintStream;

public class Homework01 {

    public static void main(String[] args) throws Exception {

        // I decided to use 'double' instead of 'int'. I wanted to 
        // keep it as consistant and simple as possible.        
        double  halfDollars,
                quarters,
                dimes,
                nickels,
                pennies,
                // This is the total numerical amount of coins.
                totalCoins,
                // These are the actual values of the coins.
                halfDollarsValue,
                quartersValue,
                dimesValue,
                nickelsValue,
                penniesValue,
                // This is the total value in penny denomination.
                totalPennies,
                // This is the total value in dollar denomination.
                totalCoinsValue;

        Scanner sc = new Scanner(System.in);
        PrintStream ps = new PrintStream("output.txt");

        System.out.println("\nThe value of your change will be computed."
                + " When there are no more entries, answer each question"
                + " with a 0."
                + "");

        System.out.println("\n\nHow many half dollars do you have?");
        halfDollars = sc.nextDouble();

        System.out.println("\nHow many quarters do you have?");
        quarters = sc.nextDouble();

        System.out.println("\nHow many dimes do you have?");
        dimes = sc.nextDouble();

        System.out.println("\nHow many nickels do you have?");
        nickels = sc.nextDouble();

        System.out.println("\nHow many pennies do you have?");
        pennies = sc.nextDouble();

        System.out.printf("\n\nYou entered:\t %.0f half dollars %n",
                halfDollars);

        ps.printf("\n\nYou entered:\t %.0f half dollars %n", halfDollars);
        System.out.printf("              \t %.0f quarters %n", quarters);
        ps.printf("              \t %.0f quarters %n", quarters);
        System.out.printf("              \t %.0f dimes %n", dimes);
        ps.printf("              \t %.0f dimes %n", dimes);
        System.out.printf("              \t %.0f nickels %n", nickels);
        ps.printf("              \t %.0f nickels %n", nickels);
        System.out.printf("              \t %.0f pennies %n", pennies);
        ps.printf("              \t %.0f pennies %n", pennies);

        totalCoins = halfDollars + quarters + dimes + nickels + pennies;
        halfDollarsValue = halfDollars * .50;
        quartersValue = quarters * .25;
        dimesValue = dimes * .10;
        nickelsValue = nickels * .05;
        penniesValue = pennies * .01;
        totalCoinsValue = halfDollarsValue + quartersValue + dimesValue
                + nickelsValue + penniesValue;
        totalPennies = totalCoinsValue / .01;

        System.out.printf("\nThe value of your %.0f coins is $%.2f "
                + "which is equivalent to %.0f pennies.%n",
                totalCoins, totalCoinsValue, totalPennies);

        ps.printf("\nThe value of your %.0f coins is $%.2f which is "
                + "equivalent to %.0f pennies.%n",
                totalCoins, totalCoinsValue, totalPennies);

        // This statement creates the loop and establishes the data end
        // trigger, which is a 'totalCoinsValue' of 0. Which 
        // essentially is 0's entered for all questions. 
        while (totalCoinsValue > 0) {

            System.out.println("\nThe value of your change will be "
                    + "computed. When there are no more entries, "
                    + "answer each question with a 0.");

            System.out.println("\n\nHow many half dollars do you have?");
            halfDollars = sc.nextDouble();

            System.out.println("\nHow many quarters do you have?");
            quarters = sc.nextDouble();

            System.out.println("\nHow many dimes do you have?");
            dimes = sc.nextDouble();

            System.out.println("\nHow many nickels do you have?");
            nickels = sc.nextDouble();

            System.out.println("\nHow many pennies do you have?");
            pennies = sc.nextDouble();

            System.out.printf("\n\nYou entered:\t %.0f half dollars %n",
                    halfDollars);
            ps.printf("\n\nYou entered:\t %.0f half dollars %n",
                    halfDollars);
            System.out.printf("              \t %.0f quarters %n", 
                    quarters);
            ps.printf("              \t %.0f quarters %n", quarters);
            System.out.printf("              \t %.0f dimes %n", dimes);
            ps.printf("              \t %.0f dimes %n", dimes);
            System.out.printf("              \t %.0f nickels %n", 
                    nickels);
            ps.printf("              \t %.0f nickels %n", nickels);
            System.out.printf("              \t %.0f pennies %n", 
                    pennies);
            ps.printf("              \t %.0f pennies %n", pennies);

            totalCoins = halfDollars + quarters + dimes + nickels + 
                    pennies;
            halfDollarsValue = halfDollars * .50;
            quartersValue = quarters * .25;
            dimesValue = dimes * .10;
            nickelsValue = nickels * .05;
            penniesValue = pennies * .01;
            totalCoinsValue = halfDollarsValue + quartersValue + 
                    dimesValue
                    + nickelsValue + penniesValue;
            totalPennies = totalCoinsValue / .01;

            System.out.printf("\nThe value of your %.0f coins is $%.2f"
                    + " which is equivalent to %.0f pennies.%n",
                    totalCoins, totalCoinsValue, totalPennies);

            ps.printf("\nThe value of your %.0f coins is $%.2f which "
                    + "is equivalent to %.0f pennies.%n", totalCoins,
                    totalCoinsValue, totalPennies);

        }

    }

}
