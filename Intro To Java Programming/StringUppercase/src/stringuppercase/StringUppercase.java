/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0 Description: Illustrates the use of the toUpperCase() method.
 */
package stringuppercase;

import java.util.Scanner;

public class StringUppercase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text;
        
        System.out.println("Enter some text: ");
        text = sc.nextLine();   //reads an entire line
        
        String upperText = text.toUpperCase();
        
        System.out.println("\nThe original text is: " + text);
        System.out.println("\nThe uppercase uppertext is " + upperText);
    } // end main
}
