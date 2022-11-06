/**
 *
 * @author Yedidyah Langsam
 * @since 03-26-2017
 * @version 1.0 *
 * Description: Reads a line from a file, one at a time. Scans each line and
 * adds 1 to the appropriate member array for each letter that it finds.
 */
package countlettersinfile;

import java.io.File;
import java.util.Scanner;

public class CountLettersInFile {

    public static final int NUMBEROFLETTERS = 26;

    public static void main(String[] args) throws Exception {

        int[] count = new int[NUMBEROFLETTERS];
        char character;
        Scanner sc = new Scanner(new File("Originalfile.txt"));

        while (sc.hasNext()) {
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                character = s.charAt(i);
                if (Character.isLetter(character)) {
                    count[(int) (Character.toUpperCase(character) - 'A')]++;
                    
                }
            }
        }

        for (int i = 0; i < NUMBEROFLETTERS; i++) {
            System.out.printf("%c = %d\n", (char) ('A' + i), count[i]);
        }
    }
}
