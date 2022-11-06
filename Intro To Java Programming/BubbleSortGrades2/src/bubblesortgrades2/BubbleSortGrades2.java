/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Sorts up to 100 records consisting of three digit student IDs 
 *              and their grades
 *              
 */
package bubblesortgrades2;

import java.io.File;
import java.util.Scanner;

public class BubbleSortGrades2 {

    public static void main(String[] args) throws Exception {
        final int MAXNUMBER = 100;
        
        int count;
        int[] id = new int[MAXNUMBER];
        String[] grade = new String[MAXNUMBER];
        
        count = populateArray(id, grade);

        bubbleSort(id, grade, count);

        System.out.println("ID\tGRADE");
        for (int i = 0; i < count; i++) {
            System.out.printf("%d\t%s\n", id[i], grade[i]);
        }
    } // end main

    /**
     * ***********************************************************************
     * Method populateArrary reads a number one at a time, places it into the
     * next available slot of the array and returns the number of values that
     * were read.
     */
    public static int populateArray(int[] id, String[] grade) throws Exception {
        Scanner sc = new Scanner(new File("BubbleSortGrades.txt"));

        int count = 0;
        while (sc.hasNext()) {
            id[count] = sc.nextInt();
            grade[count] = sc.next();
            count++;
        }
        return count;
    } // end populateArray

    /**
     * ***********************************************************************
     * BubbleSort
     */
    public static void bubbleSort(int[] id, String[] grade, int n) {
        int hold, j, pass;
        String temp;
        boolean switched = true;

        for (pass = 0; pass < n - 1 && switched; pass++) {
            // outer loop controles the number of passes
            switched = false;       // initially no interchanges have been
            // made one this pass
            for (j = 0; j < n - pass - 1; j++) {
                // inner loop governs each individual pass
                if (grade[j].compareToIgnoreCase(grade[j + 1]) > 0) {
                    // elements are out of order an interhcange is necessary
                    switched = true;
                    hold = id[j];
                    id[j] = id[j + 1];
                    id[j + 1] = hold;
                    temp = grade[j];
                    grade[j] = grade[j + 1];
                    grade[j + 1] = temp;
                } // end if
            } // end for (j = 0 ...
        } // end for (pass = 0 ...
    } // end bubbleSort method
} // end BubbleSort class
