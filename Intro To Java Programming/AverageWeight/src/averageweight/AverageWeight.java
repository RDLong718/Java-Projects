/*
 * @author Rashad Long
 * @since 07/29/20
 * @version 1.0
 * Description: This program takes the data entered and determines the total 
 * weight of the indviduals. It determines the average weight. It also determines
 * the total number of females. I ran out of time. I was trying to figure out how 
 * to count the females and it tookd too long. Unfortunately this program is not
 * completely what was asked for. 
 */
package averageweight;

import java.util.Scanner;
import java.io.PrintStream;

public class AverageWeight {

    public static void main(String[] args) throws Exception {
        int weight, counter1, average, totalWeight, femaleCount, totalFemales;

        String gender, f;

        Scanner sc = new Scanner(System.in);

        PrintStream ps = new PrintStream("stats.txt");

        totalWeight = 0;
        totalFemales = 0;
        counter1 = 0;
        femaleCount = 0;
        f = "";

        promptUser();
        weight = sc.nextInt();
        gender = sc.next();

        while (weight >= 0) {
            ++counter1;
            totalWeight = totalWeight + weight;
            weight = sc.nextInt();
            gender = sc.next();

            if (gender == "f") {
                gender = f;
                femaleCount++;
                totalFemales = totalFemales + femaleCount;
            }

        }
        // end while
        average = totalWeight / counter1;
        
        System.out.printf("The total weight is %dlbs.\n", totalWeight);
        ps.printf("The total weight is %dlbs.\n", totalWeight);
        
        System.out.printf("The average weight is: %dlbs.\n", average);
        ps.printf("The average weight is: %dlbs.\n", average);
        
        System.out.printf("The total number of females is %d\n", totalFemales);
        ps.printf("The total number of females is %d\n", totalFemales);
        
        System.out.println("The program is finished\n");
        ps.println("The Program is finished\n");

    }

    public static void promptUser() {
        System.out.println("Please enter weight followed by gender.");
        System.out.println("In order to stop enter a negative number for weight.\n");
    } // end promptUser

}
