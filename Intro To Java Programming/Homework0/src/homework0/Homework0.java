/** 
 * @author Rashad Long
 * @since 07-14-2020
 * @version 1.0
 * 
 * Description: This program asks for your first name and last name. It waits
 * until you input your name via keyboard. It then takes that information and 
 * prints a personalized message.
 * 
 */

package homework0;

import java.util.Scanner;

public class Homework0 {
    
    public static void main(String[] args) {
        String first, last;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please enter your first and last name.");
        System.out.println("Do not forget to press ENTER key.");
        
        first = sc.next();
        last = sc.next();
        
        System.out.println("\nThis is my first program!");
        System.out.println("My name is: " + first + " " + last);
          
    }
    
}


