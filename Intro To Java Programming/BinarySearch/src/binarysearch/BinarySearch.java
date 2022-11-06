/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Finds an item in an ordered file given an item to search for
 * using the Binary Search method.
 */
package binarysearch;

import java.io.File;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) throws Exception {
        final int MAXNUMBER = 1000;
        Scanner sc = new Scanner(new File("OrderedNumbersData.txt"));
        Scanner sc2 = new Scanner(System.in);
        int count, value, found;
        int[] number = new int[MAXNUMBER];

        count = populateArray(number);

        System.out.println("Enter the integer you are searching for:");
        value = sc2.nextInt();

        found = binarySearch(number, count, value);
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
        Scanner sc = new Scanner(new File("OrderedNumbersData.txt"));

        int count = 0;
        while (sc.hasNext()) {
            x[count] = sc.nextInt();
            count++;
        }
        return count;
    } // end populateArray

    /**
     * ***********************************************************************
     * Binary Search
     */
    public static int binarySearch(int[] x, int n, int item) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (item > x[middle]) {
                low = middle + 1;
            } else if (item < x[middle]) {
                high = middle - 1;
            } else { // the item has been found
                return middle;
            }
        }
        return -1;
    } // end binarySearch method
} // end BinarySearch class
