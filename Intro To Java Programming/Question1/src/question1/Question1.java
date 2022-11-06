package question1;

import java.util.Scanner;

public class Question1 {

    
        public static void main (String[] args) {
        
            
        int numberA, numberB;
        int sum = 0;
        
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Enter the next two numbers");
            numberA = sc.nextInt();
            numberB = sc.nextInt();
           
            while  (numberA > numberB) {
                System.out.println(numberA + " " + numberB);
                    // note the order of paramaeters
                    sum = sum + calculate(numberA, numberB);
                    sum = sum + calculate(numberB, numberA);
                    System.out.println("Enter the next two numbers");
                    numberA = sc.nextInt();
                    numberB = sc.nextInt();
                }
                System.out.println("Sum = " + sum);
            }//end main
        
        

    public static int calculate(int x, int y) {
        return x * 2 - y * 2;
    }
}
