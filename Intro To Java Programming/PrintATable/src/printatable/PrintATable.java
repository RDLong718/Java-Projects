/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 * 
* Description: Prints a table of squares, square roots and cubes for 1 to 10.
 */
package printatable;

public class PrintATable {

    public static void main(String[] args) {

        double number, square, cube, root;
       
        System.out.printf("\nNumber\tSquare\tRoot\tCube\n\n");
        for (number = 1; number <= 10; number++) {
            square = Math.pow(number, 2);
            root = Math.sqrt(number);
            cube = Math.pow(number, 3);
            System.out.printf("%.0f\t%.0f\t%.3f\t%.0f\n", number, square, root, cube);
        }
    }
}
