/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Assigns comments given a numerical grade.
 */
package gradingcomment;

import java.util.Scanner;

import java.util.Scanner;

public class GradingComment {

    public static void main(String[] args) {
        int grade;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a grade from 1 to 10: ");
        while (sc.hasNext()) {
            grade = sc.nextInt();
            comment(grade);
        } // end while
    }

    // method assign comments given a numerical grade
    public static void comment(int score) {
        switch (score) {
            case 10:
                System.out.println("Exceptional!\n");
                break;
            case 9:
            case 8:
                System.out.println("Good!\n");
                break;
            case 7:
            case 6:
            case 5:
                System.out.println("Barely Passing.\n");
                break;
            case 4:
            case 3:
                System.out.println("Flunking!\n");
                break;
            case 2:
            case 1:
            case 0:
                System.out.println("Miserable!\n");
                break;
            default:
                System.out.println("Invalid score!\n");
                break;
        } // end switch
    } // end comment
}
