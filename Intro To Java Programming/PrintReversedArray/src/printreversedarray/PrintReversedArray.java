/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Prints and counts the numbers in an external file and prints
 * them in reversed order.
 */
package printreversedarray;

import java.io.File;
import java.util.Scanner;

public class PrintReversedArray {

    public static void main(String[] args) throws Exception{
        final int MAXNUMBER = 1000;
        int i, count;
        int[] number = new int[MAXNUMBER];

        count = populateArray(number);

        System.out.printf("\nThe array contains % d elements.\n", count);
        for (i = count - 1; i >= 0; i--) {
            System.out.printf("%d\n", number[i]);
        }
    } // end main
    
    // Method populateArrary reads a number one at a time, places it into the 
    // next available slot of the array and returns the number of values 
    // that were read.
    public static int populateArray(int[] x) throws Exception {
        Scanner sc = new Scanner(new File("NumbersData.txt"));
        
        int count = 0;
        while (sc.hasNext()) {
            x[count] = sc.nextInt();
            count++;
        }
        return count;
    } // end populateArray
}
