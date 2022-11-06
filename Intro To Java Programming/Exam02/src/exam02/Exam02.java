
/**
 * @author Rashad Long
 * @since 07-25-2020
 * @version 10.0
 * Description: takes the array and tells us the 
 * even and odd numbers and tells us the 
 * averages. Did not have time to do everything. 
 * I was able to populate array
 * and I was able to find the number of odd and the 
 * number of even. I did not have time to formulate
 * the rest. I know I could have given more time. 
 **/
package exam02;
 

import java.io.File;
import java.util.Scanner;
import java.io.PrintStream;

public class Exam02 {

    public static void main(String[] args) throws Exception {
        final int MAXNUMBER = 100;
        Scanner sc = new Scanner(new File("Data.txt"));

        int count,
                a,
                countEven = 0,
                countOdd = 0;

        int[] data = new int[MAXNUMBER];

        count = populateArray(data);

        for (a = 0; a < data.length; a++) {
            if (data[a] % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }
        System.out.println("Total number of even numbers "
                + "in an array java: " + countEven);
        System.out.println("Total number of odd numbers "
                + "in an array java: " + countOdd);
        System.out.println("Total number of odd numbers "
                + "in an array java: " + count);

    }

    // end main
    /**
     * Method populateArrary reads a number one at 
     * a time, places it into the
     * next available slot of the array and returns 
     * the number of values that
     * were read.
     */
    public static int populateArray(int[] data) throws 
            Exception {
        Scanner sc = new Scanner(new File("Data.txt"));

        int count = 0;
        while (sc.hasNext()) {
            data[count] = sc.nextInt();
            count++;
        }
        return count;
    } // end populateArray
}
