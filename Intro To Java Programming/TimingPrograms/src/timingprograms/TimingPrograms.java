/**
 *
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Illustrates how to time a program as well as how to obtain the
 * time of day.
 */
package timingprograms;

public class TimingPrograms {

    public static void main(String[] args) {
        double startTime = System.currentTimeMillis();

        for (int i = 1; i <= 100; i++) {
            for (int j = 1; j <= 100; j++) {

                // Do something......
                double x = Math.sqrt(i * i + j * j);
                System.out.printf("%d   %d   %f\n", i, j, x);

            } // end for ... second
        } // end for ... first

        double endTime = System.currentTimeMillis();
        System.out.println("Total execution time: "
                            + (endTime - startTime) / 1000 + " seconds.");
    }
}
