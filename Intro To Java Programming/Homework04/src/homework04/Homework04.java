/**
 * @author Rashad Long
 * @since 08-06-2020
 * @version 1.0
 *
 * Description: This program reads data file "Temperatures.txt". 
 * The data in the file represents average temperatures, 
 * arranged by week. The program prints each line of data followed 
 * by the highest average for the week, the lowest average, and 
 * the average of averages. It does this by calling on 3 different
 * methods. It then determines if the average temperature was the 
 * same on any two consecutive days in the week. It does this also 
 * by invoking a method. The program continues to calculate and 
 * print how many weeks in total were processed. Finally it calculates 
 * and prints the highest average of all and which week it occurred in.
 * All output goes to the screen and also to "Homework04Output.txt".
 * I think I should have used arrays and I would have had a better 
 * looking code, however I am still not comfortable with them yet so 
 * I tried to keep things simple and basic.
 */
package homework04;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class Homework04 {

    static PrintStream ps;

    public static void main(String[] args) throws Exception {

        double  monday,
                tuesday,
                wednesday,
                thursday,
                friday,
                temperatureAverage,
                highestMean,
                lowestMean,
                highestOverall,
                highestCounter;

        int counter = 0;
        int highestDay = 0;

        highestOverall = Double.MIN_VALUE;
        highestCounter = Double.MIN_VALUE;

        // These variables generate the Heading.
        String day1 = "Monday";
        String day2 = "Tuesday";
        String day3 = "Wednesday";
        String day4 = "Thursday";
        String day5 = "Friday";
        String avgHeading = "Average";
        String highestHeading = "Highest";
        String lowestHeading = "Lowest";
        String consecutiveDaysHeading = "Consecutive";
        String consecutiveDays;

        String highDay = "";

        Scanner scanner = new Scanner(new File("Temperatures.txt"));
        PrintStream ps = new PrintStream("Homework04Output.txt");

        System.out.printf("%-8s %-9s %-8s %10s %8s %9s %8s %9s "
                + "%13s\n\n", day1, day2, day3, day4, day5,
                highestHeading, lowestHeading, avgHeading,
                consecutiveDaysHeading);

        ps.printf("%-8s %-9s %-8s %10s %8s %9s %8s %9s "
                + "%13s\n\n", day1, day2, day3, day4, day5,
                highestHeading, lowestHeading, avgHeading,
                consecutiveDaysHeading);

        // This while statement reads the data via the scanner
        // until there is no more data left.
        while (scanner.hasNext()) {
            monday = scanner.nextInt();
            tuesday = scanner.nextInt();
            wednesday = scanner.nextInt();
            thursday = scanner.nextInt();
            friday = scanner.nextInt();

            // This counter will be used later on to generate how
            // many weeks were processed and to generate which
            // week the highest overall average occured. 
            ++counter;

            // Invokes the computeHighest method in order to receive the 
            // highest average.
            highestMean = computeHighest(monday, tuesday,
                    wednesday, thursday, friday);

            // Invokes the computeLowest method in order to receive the
            // lowest average.
            lowestMean = computeLowest(monday, tuesday,
                    wednesday, thursday, friday);

            // Invokes the computeAverage method in order to receive the
            // temperature averages. 
            temperatureAverage = computeAverage(monday, tuesday,
                    wednesday, thursday, friday);

            // Invokes the computeConsecutive method in order to tell us 
            // if the same temperature happened 2 days in a row.
            consecutiveDays = computeConsecutive(monday, tuesday,
                    wednesday, thursday, friday);

            // This if statement generates the highest average overall.
            // It also finds out the week it fell on.
            if (highestMean > highestOverall) {
                highestOverall = highestMean;
                highestCounter = counter;
            }

            // These if statements generate the day of the week that the
            // highest overall avearage falls on.
            if (monday >= highestOverall) {
                highestOverall = monday;
                highDay = "Monday";
            } else if (tuesday >= highestOverall) {
                highestOverall = tuesday;
                highDay = "Tuesday";
            } else if (wednesday >= highestOverall) {
                highestOverall = wednesday;
                highDay = "Wednesday";
            } else if (thursday >= highestOverall) {
                highestOverall = thursday;
                highDay = "Thursday";
            } else if (friday >= highestOverall) {
                highestOverall = friday;
                highDay = "Friday";
            }

            System.out.printf("%6.0f %9.0f %11.0f %10.0f %8.0f "
                    + "%9.1f %8.1f %9.1f %13s\n", monday, tuesday,
                    wednesday, thursday, friday, highestMean,
                    lowestMean, temperatureAverage, consecutiveDays);

            ps.printf("%6.0f %9.0f %11.0f %10.0f %8.0f "
                    + "%9.1f %8.1f %9.1f %13s\n", monday, tuesday,
                    wednesday, thursday, friday, highestMean,
                    lowestMean, temperatureAverage, consecutiveDays);
        }

        System.out.printf("\n\nThe total number of weeks processed "
                + "is %d.\n", counter);

        ps.printf("\n\nThe total number of weeks processed "
                + "is %d.\n", counter);

        System.out.printf("The highest average of all is %.0f. It "
                + "occurred in week %.0f and fell on a %s.\n",
                highestOverall, highestCounter, highDay);

        ps.printf("The highest average of all is %.0f. It "
                + "occurred in week %.0f and fell on a %s.\n",
                highestOverall, highestCounter, highDay);
    }

    // This method sums each average of all the days and calculates
    // the average. It then returns that average to the main.
    public static double computeAverage(double mon, double tues,
            double wed, double thurs, double fri) {

        double temperatureAverage;

        temperatureAverage = (mon + tues + wed + thurs + fri) / 5;

        return temperatureAverage;
    }

    // This method takes that averages of each day and calculates
    // which average was the highest. It then returns that highest
    // average to the main.
    public static double computeHighest(double monday, double tuesday,
            double wednesday, double thursday, double friday) {

        double highestMean;

        highestMean = Double.MIN_VALUE;

        if (monday >= tuesday && monday >= wednesday
                && monday >= thursday && monday >= friday) {
            highestMean = monday;
        } else if (tuesday >= monday && tuesday >= wednesday
                && tuesday >= thursday && tuesday >= friday) {
            highestMean = tuesday;
        } else if (wednesday >= monday && wednesday >= tuesday
                && wednesday >= thursday && wednesday >= friday) {
            highestMean = wednesday;
        } else if (thursday >= monday && thursday >= tuesday
                && thursday >= wednesday && thursday >= friday) {
            highestMean = thursday;
        } else if (friday >= monday && friday >= tuesday
                && friday >= wednesday && friday >= thursday) {
            highestMean = friday;
        }

        return highestMean;
    }

    // This method takes that averages of each day and calculates
    // which average was the lowest. It then returns that lowest
    // average to the main.
    public static double computeLowest(double monday, double tuesday,
            double wednesday, double thursday, double friday) {

        double lowestMean;

        lowestMean = Double.MAX_VALUE;

        if (monday <= tuesday && monday <= wednesday && monday
                <= thursday && monday <= friday) {
            lowestMean = monday;
        } else if (tuesday <= monday && tuesday <= wednesday
                && tuesday <= thursday && tuesday <= friday) {
            lowestMean = tuesday;
        } else if (wednesday <= monday && wednesday <= tuesday
                && wednesday <= thursday && wednesday <= friday) {
            lowestMean = wednesday;
        } else if (thursday <= monday && thursday <= tuesday
                && thursday <= wednesday && thursday <= friday) {
            lowestMean = thursday;
        } else if (friday <= monday && friday <= tuesday
                && friday <= wednesday && friday <= thursday) {
            lowestMean = friday;
        }

        return lowestMean;
    }

    // This method takes the averages from each day and calculates
    // if the same average happened on two consecutive days. It then
    // returns a "YES" or "NO".
    public static String computeConsecutive(double monday,
            double tuesday, double wednesday, double thursday,
            double friday) {

        String consecutiveDays = "";
        if (monday == tuesday || tuesday == wednesday
                || wednesday == thursday || thursday == friday) {
            consecutiveDays = "YES";
        } else if (monday != tuesday || tuesday != wednesday || wednesday
                != thursday || thursday != friday) {
            consecutiveDays = "NO";
        }

        return consecutiveDays;
    }
}
