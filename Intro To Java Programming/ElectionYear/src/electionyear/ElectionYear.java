/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: The program determines how close an election year is.
 */
package electionyear;

import java.util.Scanner;

public class ElectionYear {

    public static void main(String[] args) {
        int year;
        Scanner sc = new Scanner(System.in);

        System.out.println("What year is this? ");
        year = sc.nextInt();
        switch (year % 4) {
            case 0:
                System.out.printf("\nThis year is an election year.\n");
                break;
            case 1:
                System.out.printf("\nLast year was an election year.\n");
                break;
            case 2:
                System.out.printf("\nThe election was two years ago.\n");
                break;
            case 3:
                System.out.printf("\nNext year will be an election year.\n");
                break;
        }
    }
}
