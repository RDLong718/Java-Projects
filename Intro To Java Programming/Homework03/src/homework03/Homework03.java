/**
 * @author Rashad Long
 * @since 07-30-2020
 * @version 1.0
 *
 * Description: This program calculates student semester 
 * averages, final letter grades, class average, and the 
 * distribution of letter grades. The program does this 
 * by reading the data in the 'StudentGrades.txt' file. 
 * The main method reads the file and calls on a method 
 * that computes the semester averages. It then invokes a 
 * method that returns the letter grades. The main method 
 * then invokes a method that prints out each students 
 * record until no more students are processed. The main 
 * method then calculates the class average, tabulates the 
 * grade distribution, and tabulates the lowest, highest
 * and average grade. It then calls on 2 more methods to 
 * print out that information. When the program is finished 
 * it lets the user know that it is all done. All output is 
 * written to a file called "Roster.txt" as well as printed 
 * on the screen. I did not find this as difficult as the
 * other homework assignments. I think using methods makes
 * it less confusing. Also, it makes the program more 
 * readable. 3 weeks ago I knew nothing about Java, now I
 * am writing programs! :).
 */

package homework03;

import java.util.Scanner;
import java.io.File;
import java.io.PrintStream;

public class Homework03 {

    static PrintStream ps;

    public static void main(String[] args) throws Exception {

        int     test1,
                test2,
                finalTest,
                // These variables will be the counters for
                // the grades A-F.
                counterA = 0,
                counterB = 0,
                counterC = 0,
                counterD = 0,
                counterF = 0;

        double  semesterAverage,
                counterAverage = 0,
                sumAverage = 0,
                classAverage = 0,
                highestAverage = Double.MIN_VALUE,
                lowestAverage = Double.MAX_VALUE;
        
        char    grade;
        
        String  name;
        //These are the variables for the heading.
        String headingName = "Student Name";
        String headingTest1 = "Test1";
        String headingTest2 = "Test2";
        String headingFinal = "Final";
        String headingAverage = "Average";
        String headingGrade = "Grade";
        
        // All outputs also go to the "Roster.txt" file.
        ps = new PrintStream("Roster.txt");
        
        // The "StudentGrades.txt" file is what the 
        // scanner reads data from.
        Scanner scanner = new Scanner(new File("StudentGrades.txt"));

        System.out.printf("%-12s %12s %8s %8s %9s %7s\n\n",
                headingName, headingTest1, headingTest2, headingFinal,
                headingAverage, headingGrade);

        ps.printf("%-12s %12s %8s %8s %9s %7s\n\n",
                headingName, headingTest1, headingTest2, headingFinal,
                headingAverage, headingGrade);
        
        // This "while" loop reads the data from the 
        // "StudentGrades.txt" file and continues reading until 
        // there is no more data.
        while (scanner.hasNext()) {
            name = scanner.next();
            test1 = scanner.nextInt();
            test2 = scanner.nextInt();
            finalTest = scanner.nextInt();
            
            // Invokes the "computeAverage" method.
            semesterAverage = computeAverage(test1, test2, finalTest);
            
            // This "if" statement begins to count the averages.
            if (semesterAverage >= 0) {
                ++counterAverage;
            }
            
            // These "if" and "else if" statements determine the highest
            // and lowest averages. 
            if (semesterAverage < lowestAverage) {
                lowestAverage = semesterAverage;
            } else if (semesterAverage > highestAverage) {
                highestAverage = semesterAverage;
            }

            sumAverage = sumAverage + semesterAverage;

            classAverage = sumAverage / counterAverage;
            
            // Invokes the "letterGrade" method.
            grade = letterGrade(semesterAverage);
            
            // These "if" and "else if" statements count the amount of 
            // each letter grade. 
            if (grade == 'A') {
                ++counterA;
            } else if (grade == 'B') {
                ++counterB;
            } else if (grade == 'C') {
                ++counterC;
            } else if (grade == 'D') {
                ++counterD;
            } else if (grade == 'F') {
                ++counterF;
            }
            
            // Invokes the "printRecord" method.
            printRecord(name, test1, test2, finalTest, 
                    semesterAverage, grade);
        }
        
        // Invokes the "printGradeDistribution" method.
        printGradeDistribution(counterA, counterB, counterC, 
                counterD, counterF);
        
        // Invokes the "printStatistics" method.
        printStatistics(classAverage, lowestAverage, highestAverage);
       
        // End of program.
        System.out.println("\nALL DONE!");

        ps.println("\nALL DONE!");
    }

    // This method takes test1, test2, and finalTest and returns the
    // students average.
    public static double computeAverage(int test1, int test2, 
            int finalTest) {

        double semesterAverage;

        semesterAverage = 0.20 * test1 + 0.30 * test2 + .50 * finalTest;

        return semesterAverage;
    }

    // This method takes the semesterAverage and returns the 
    // letter grade.
    public static char letterGrade(double semesterAverage) {

        char grade;
        grade = 'Z';

        if (semesterAverage >= 90) {
            grade = 'A';
        } else if (semesterAverage >= 80) {
            grade = 'B';
        } else if (semesterAverage >= 70) {
            grade = 'C';
        } else if (semesterAverage >= 60) {
            grade = 'D';
        } else if (semesterAverage < 60) {
            grade = 'F';
        }

        return grade;
    }

    // This method takes the students name, test scores, average
    // and letter grade. It then prints the record. 
    public static void printRecord(String name, int test1, int test2,
            int finalTest, double semesterAverage, char grade) {

        System.out.printf("%-12s %12d %8d %8d %9.0f %7c\n", name, test1,
                test2, finalTest, semesterAverage, grade);
        
        ps.printf("%-12s %12d %8d %8d %9.0f %7c\n", name, test1,
                test2, finalTest, semesterAverage, grade);
    }
    
    // This method takes the grade distribution data. 
    // It then prints the record.
    public static void printGradeDistribution(int counterA, 
            int counterB, int counterC, int counterD, int counterF) {

        System.out.printf("\nThe number of A grades is: %6d\n"
                , counterA);

        ps.printf("\nThe number of A grades is: %6d\n"
                , counterA);

        System.out.printf("The number of B grades is: %6d\n"
                , counterB);

        ps.printf("The number of B grades is: %6d\n", counterB);

        System.out.printf("The number of C grades is: %6d\n"
                , counterC);

        ps.printf("The number of C grades is: %6d\n", counterC);

        System.out.printf("The number of D grades is: %6d\n"
                , counterD);

        ps.printf("The number of D grades is: %6d\n", counterD);

        System.out.printf("The number of D grades is: %6d\n"
                , counterD);

        ps.printf("The number of D grades is: %6d\n", counterD);
    }

    // This method takes the class average, lowest average and highest
    // average. It then prints the record.
    public static void printStatistics(double classAverage, 
            double lowestAverage, double highestAverage) {

        System.out.printf("\nClass Average: %8.1f\n", classAverage);

        ps.printf("\nClass Average: %8.1f\n", classAverage);

        System.out.printf("Lowest Average: %7.1f\n", lowestAverage);

        ps.printf("Lowest Average: %7.1f\n", lowestAverage);

        System.out.printf("Highest Average: %6.1f\n", highestAverage);

        ps.printf("Highest Average: %6.1f\n", highestAverage);
    }
}
