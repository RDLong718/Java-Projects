/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Plays the game of Heads or Tails
 */
package headortails;

import java.util.Scanner;
import java.util.Random;

public class HeadOrTails {

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        printInstructions();
        System.out.print("\nHow many times do you want to play? ");
        n = sc.nextInt();
        play(n);
    }

    /**
     * ***********************************************************************
     * prints the instructions for the user
     */
    public static void printInstructions() {
        System.out.println("This is the game of \'Heads or Tails\'.");
        System.out.println("I will flip a coinl you call it.");
        System.out.println("To call \'Heads\', type 0; to call \'Tails\', type 1.");;
        System.out.println("As I toss my coin I will tell you to \'Call it\'.");
    } // end ptintInstructions

    /**
     * ***********************************************************************
     * The play method actually plays the game. The computer does the tossing,
     * the used does the calling
     */
    public static void play(int n) {
        int coin, i, lose = 0, win = 0;

        for (i = 0; i < n; i++) {
            System.out.print("Call it: ");
            coin = toss();
            if (getCallFromUser() == coin) {
                ++win;
                reportAWin(coin);
            } else {
                ++lose;
                reportALoss(coin);
            }
        } // end for loop
        printFinalReport(win, lose, n);
    } // end play

    /**
     * ***********************************************************************
     * The toss method generates a random toss. It returns 0 for heads and 1 for
     * tails.
     */
    public static int toss() {
        Random random = new Random();

        return random.nextInt() % 2;
    } // end toss

    /**
     * ***********************************************************************
     * The getCallFromUser method returns 0 for heads and 1 for tails.
     */
    public static int getCallFromUser() {
        int guess;
        Scanner sc = new Scanner(System.in);

        guess = sc.nextInt();
        //checki that only a 1 or 0 is entered
        while (guess != 0 && guess != 1) {
            System.out.println("ERROR: type 0 for heads and 1 for tails.\n");
            guess = sc.nextInt();
        } // end while
        return guess;
    } // end getCallFromUser()

    /**
     * ***********************************************************************
     * The reportAWin method reports a win.
     */
    public static void reportAWin(int coin) {
        if (coin == 0) {
            System.out.println("I have heads, you win.");
        } else {
            System.out.println("I have tails, you win.");
        }
    }

    /**
     * ***********************************************************************
     * The reportALoss method reports a win.
     */
    public static void reportALoss(int coin) {
        if (coin == 0) {
            System.out.println("I have heads, you lose.");
        } else {
            System.out.println("I have tails, you lose.");
        }
    }

    /**
     * ***********************************************************************
     * The printFinalReport method reports the final statistics of the game.
     */
    public static void printFinalReport(int win, int lose, int n) {
        System.out.printf("Final Report\n");
        System.out.printf("Number of games you won:   %d\n", win);
        System.out.printf("Number of games you lost:  %d\n", lose);
        System.out.printf("Total number of games:     %d\n", n);
    } // end printFinalReport
}
