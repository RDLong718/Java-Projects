/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Java program that uses Character.isLowerCase and isUpperCase
 */
package programusingmethodsislowercaseandisuppercase;

public class ProgramUsingMethodsisLowerCaseAndisUpperCase {

    public static void main(String[] args) {
        char[] values = {'C', 'a', 't', '5'};
        // See if the chars are lower or uppercase.
        for (char value : values) {
            System.out.println(value);
            System.out.println(Character.isLowerCase(value));
            System.out.println(Character.isUpperCase(value));
        }
    } // end main    
} // end ProgramUsingMethodsisLowerCaseAndisUpperCase
