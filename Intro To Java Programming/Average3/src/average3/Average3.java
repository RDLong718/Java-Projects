/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0 Description: Finds the average of a list of numbers using the
 * end of file method. method hasNext() checks to see if there are any more
 * values in the file.
 */
package average3;

import java.io.File;
import java.util.Scanner;

public class Average3 {

    public static void main(String[] args) throws Exception {
        int counter;
        double average, number, sum;

        Scanner sc = new Scanner(new File("numbers.txt"));

        counter = 0;
        sum = 0;

        while (sc.hasNext()) {
            number = sc.nextDouble();
            ++counter;
            sum = sum + number;
            // number = sc.nextDouble();
        } // end while
        average = sum / counter;
        System.out.printf("The average is : %.1f\n", average);

    } // end main
}
