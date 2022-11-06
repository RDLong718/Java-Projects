/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangleapp;

/**
 *
 * @author 
 */
public class RecursionArrays {
    
    public static void main(String[] args) {
        
        int[] numbers = {7,9,20,16,3,54,3};
        int val = 54;
        int val2 = 8;
        System.out.println("linearsearch on " + val + " " +
                linearSearch(numbers, val, 0, numbers.length-1));
        System.out.println("linearsearch on " + val2 + " " +
                linearSearch(numbers, val2, 0, numbers.length-1));
    }
    /** Algorithm to search an UNsorted array for a specific value
     * @param arr : this is the array to search
     * @param key : this is the value that we are searching for
     * @return true if found, false otherwise
     */
    public static boolean linearSearch(int[] arr, int key, int beg, int end) {
        
        // Base case: array is empty, return not found
        if (end-beg < 0)
            return false;
        // chip a piece off of the array and do non-recursive work
        if (arr[beg] == key)
            return true;
        
        // call linearSearch on array of size n-1
        return linearSearch(arr, key, beg+1, end);
    }
}