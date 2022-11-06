/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Java program that uses Character.isDigit
 */
package programusingmethodisdigit;

public class ProgramUsingMethodisDigit {

    public static void main(String[] args) {

        char value1 = '9';
        char value2 = 'Y';
        char value3 = ' ';

        // See if these characters are digits.
        System.out.println(Character.isDigit(value1));
        System.out.println(Character.isDigit(value2));
        System.out.println(Character.isDigit(value3));
    }
}
