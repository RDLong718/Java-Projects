/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Java program that uses Character.isLetter and String.charAt
 */
package programusingmethodisletterandcharat;

public class ProgramUsingMethodisLetterAndcharAt {

    public static void main(String[] args) {
        String value = "abc123";
        // Loop through characters in this String.
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);

            // See if the character is a letter or not.
            if (Character.isLetter(c)) {
                System.out.println(c + " = LETTER");
            } else {
                System.out.println(c);
            }
        } // end for
    } // end main
}  // end ProgramUsingMethodisLetterAndcharAt
