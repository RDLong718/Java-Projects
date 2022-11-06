/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Finds the largest element in an array
 */
package findlargestinarray;

import java.io.File;
import java.util.Scanner;

public class FindLargestInArray {

    public static void main(String[] args) throws Exception {
        final int MAXNUMBER = 1000;
        int i, count;
        int[] number = new int[MAXNUMBER];

        count = populateArray(number);

        System.out.printf("\nThe array contains % d elements.\n", count);
        System.out.printf("\nThe largest element is: %d.\n",
                findLargest(number));
    } // end main

    /**
     * ***********************************************************************
     * Method populateArrary reads a number one at a time, places it into the 
     * next available slot of the array and returns the number of values 
     * that were read.
     */
    public static int populateArray(int[] x) throws Exception {
        Scanner sc = new Scanner(new File("NumbersData.txt"));
        
        int count = 0;
        while (sc.hasNext()) {
            x[count] = sc.nextInt();
            count++;
        }
        return count;
    } // end populateArray
    
    /**
     * ***********************************************************************
     * Finds the largest element in an array
     */
    public static int findLargest(int[] x) {
        int largest, i;

        largest = x[0];
        for (i = 1; i < x.length; i++) {
            if (x[i] > largest) {
                largest = x[i];
            }
        }
        return largest;
    } // end findLargest  
}
