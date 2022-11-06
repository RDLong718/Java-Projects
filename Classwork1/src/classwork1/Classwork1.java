/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classwork1;

/**
 *
 * @author rdlon
 */
public class Classwork1 {

    public static void main(String[] args) {

        int[] numbers = {1, 5, 4, 8, 10};
        System.out.println(numbers[0]);
        System.out.println(removeFirstDuplicate(numbers));
        
    }

    /**
     *
     * @param arr
     * @return
     */
    public static boolean removeFirstDuplicate(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; i < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
