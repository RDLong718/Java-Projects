/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import static main.InsertionSort.printArray;

/**
 *
 * @author rdlon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String make = "Hello This is a program that is supposed to be executed using Make";
       
        System.out.println(make);
        int arr[] = {12, 11, 13, 5, 6};

        InsertionSort ob = new InsertionSort();
        ob.sort(arr);
        printArray(arr);

        
        
    }
    
}
