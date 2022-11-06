/**
 *
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Illustrates how to get the current date and time.
 */
package timeanddate;

import java.util.Date;

public class TimeAndDate {

    public static void main(String[] args) {
        // Instantiate a Date object
        Date date = new Date();

        // display time and date using toString()
        System.out.println(date.toString());

    }
}
