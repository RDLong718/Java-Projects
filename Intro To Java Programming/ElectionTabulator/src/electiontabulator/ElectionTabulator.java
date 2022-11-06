/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Program tabulates the result of an election.
 */
package electiontabulator;

import java.util.Scanner;

public class ElectionTabulator {

    public static void main(String[] args) {
        final int NUMBEROFCANDIDATES = 4;

        int candidate;
        int[] count = new int[NUMBEROFCANDIDATES];
        Scanner sc = new Scanner(System.in);

        //Tabulate the votes
        System.out.printf("\nEnter your choice as a number from 1 to %d. ",
                NUMBEROFCANDIDATES);
        System.out.printf("\nEnter zero to stop.\n");
        candidate = sc.nextInt();
        while (candidate > 0 && candidate <= NUMBEROFCANDIDATES) {
            ++count[candidate-1];
            System.out.printf("\nEnter your choice as a number from 1 to %d. ",
                    NUMBEROFCANDIDATES);
            System.out.printf("\nEnter zero to stop.\n");
            candidate = sc.nextInt();
        }

        // Print the results
        for (candidate = 0; candidate < NUMBEROFCANDIDATES; candidate++) {
            System.out.printf("Candidate %d received %d votes.\n",
                    candidate + 1, count[candidate]);
        }
    } // end main
} // end ElectionTabulator
