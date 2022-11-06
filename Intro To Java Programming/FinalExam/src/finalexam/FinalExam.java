/*@author Rashad Long
 * @since 08-18-2020
 * @version 1.0
 * This program reads in data from file and then sorts it and prints
*  it in 2 columns. It contains 2 arrays. I did not have enought time to
*  finish the bubble sort. If I had more tiem I would have been able to finish. 
*  All I had time to do was to scan in the 2 arrays
*/

package finalexam;

import java.io.File;
import java.util.Scanner;

public class FinalExam {

    public static void main(String args[]) throws Exception {
        int i, num;
        double answer;
        int[] arr1 = new int[100];
        double[] arr2 = new double[100];
        num = readData(arr1, arr2);
        answer = modifyArray(arr1, arr2, num);
        sortArray(arr1, num);

        System.out.println(arr1[0]);

    }

    /* This method reads two values at a time from the input file. The first 
    *  value of each line is sotted in arrOne, and the second value is stored 
    *  in arrTwo. This is repeated until there are no more values in the file. 
    * The method then returns the number of rows that were read in. 
     */
    public static int readData(int[] arrOne, double[] arrTwo) throws Exception {
        Scanner sc = new Scanner(new File("input.txt"));

        int num = 0;
        while (sc.hasNextInt()) {
            arrOne[num] = sc.nextInt();
            arrTwo[num] = sc.nextDouble();
            num++;
        }
        return num;
    }

    public static double modifyArray(int[] alpha, double[] beta, int num)
            throws Exception {
        int answer = 0;
        int i;

        for (i = 0; i < num; i++) {
            answer = alpha[i] / 2;
            beta[i] = answer + beta[i];
            System.out.println(beta[i]);

        }

        return answer;
    }

    public static void sortArray(int[] arrParallel, int k) {
        int hold, j, pass;
        boolean switched = true;

        for (pass = 0; pass < k - 1 && switched; pass++) {
            // outer loop controles the number of passes
            switched = false;       // initially no interchanges have been
            // made one this pass
            for (j = 0; j < k - pass - 1; j++) {
                // inner loop governs each individual pass
                if (arrParallel[j] > arrParallel[j + 1]) {
                    // elements are out of order an interhcange is necessary
                    switched = true;
                    hold = arrParallel[j];
                    arrParallel[j] = arrParallel[j + 1];
                    arrParallel[j + 1] = hold;
                }
            }
            System.out.println(arrParallel[j]);
        }
    }
}
