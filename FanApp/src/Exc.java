/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rdlon
 */
import java.util.Scanner;

public class Exc {
   public static void main(String [] args)  {

      final int NUM = 5;
      int[] arr = new int[NUM];
      Scanner keyboard = new Scanner(System.in);

       try {
           for (int i = 0; i <= NUM; i++) {
               System.out.println("Enter an integer: ");
               arr[i] = keyboard.nextInt();
           }
           System.out.println();
       } catch (ArrayIndexOutOfBoundsException ex) {
           System.out.println("*** out of bounds of array!");
       } catch (IndexOutOfBoundsException ex) {
           System.out.println(ex.getMessage());
       } catch (RuntimeException ex) {
           System.out.println("***RuntimeException");
       } 

      System.out.println("Have a nice holiday!");
   }
}
