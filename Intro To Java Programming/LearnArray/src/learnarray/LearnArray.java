/**
 * @author Omran Khoja
 * @since 08/10/20
 * @version 1.0
 *
 * Description: This program calls a method to populate an array with integers
 * from a file and return the number of integers it scanned. It then calls a
 * second method to evaluate and print the average of the integers in the array
 * and the count of even numbers greater than and the number of odd numbers
 * lesser than the average.
 */
package learnarray;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class LearnArray {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(new File("Data.txt"));
        final int MAXSIZE = 50;
        int[] arr = new int[MAXSIZE];
        int fileSize;
        int count = 0;

        fileSize = populateArray(sc, arr);

        printStats(arr, fileSize);

        for (int i : arr) {
            if (i > 0) {
                System.out.println(i);
            }
            if (i > 55) {
                count++;
            }

        }
        System.out.println("The amount of numbers higher than 55 is "
                + count);

    }

    // Populates the specified array using the provided scanner and returns the
    // number of integers inserted into the array.
    public static int populateArray(Scanner sc, int[] arr) {
        int index = 0;

        while (sc.hasNextInt()) {
            arr[index] = sc.nextInt();
            index++;
        }
        return index;
    }

    // Uses the provided array and its size to determine and print the average,
    // how many even numbers are greater than and how many odd numbers
    // are lesser than the average.
    public static void printStats(int[] arr, int size) {
        int i, greater = 0, lesser = 0;
        double sum = 0, average;

        for (i = 0; i < size; i++) {
            sum += arr[i];
        }
        average = sum / size;

        for (i = 0; i < size; i++) {
            if (arr[i] % 2 == 0) {
                if (arr[i] > average) {
                    greater++;
                }
            } else {
                if (arr[i] < average) {
                    lesser++;
                }
            }
        }
        System.out.printf("The average of the set is: %.1f%n", average);
        System.out.printf("%d even numbers are above the avg.%n", greater);
        System.out.printf("%d odd numbers are below the avg.%n", lesser);
    }

    public static void printArray(int[] arr) {
        int i;

        for (i = 0; i < arr.length; i++) {
            if (i > 0) {
                System.out.println(i);
            }
        }
    }
}
