/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Finds an item in a file given an item to search for using the
 * Sequential Search method.
 */
package sequentialsearch;

import java.io.File;
import java.util.Scanner;

public class SequentialSearch {

    public static void main(String[] args) throws Exception {
        final int MAXNUMBER = 1000;
        Scanner sc = new Scanner(new File("NumbersData.txt"));
        Scanner sc2 = new Scanner(System.in);
        int count, value, found;
        int[] number = new int[MAXNUMBER];

        count = populateArray(number);

        System.out.println("Enter the integer you are searching for:");
        value = sc2.nextInt();

        found = sequentialSearch(number, count, value);
        if (found == -1) {
            System.out.printf("\n%d was not found.\n", value);
        } else {
            System.out.printf("\n%d was found in position %d.\n", value, found);
        }
    } //end main

    /**
     * ***********************************************************************
     * Method populateArrary reads a number one at a time, places it into the
     * next available slot of the array and returns the number of values that
     * were read.
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
     * Sequential Search
     */
    public static int sequentialSearch(int[] x, int n, int item) {
        int i;
        for (i = 0; i < n; i++) {
            if (x[i] == item) {
                return i;
            }
        }
        return -1;
    } // end sequentialSearch
} // end SequentialSearch class
