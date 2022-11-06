/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datachecker;

import java.io.File;

import java.util.*;

public class DataChecker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {

            //this loads the file into the scanner object
            Scanner fileScanner = new Scanner(new File("numbers.txt"));

            int lineNumber = 0;
            int number = 0;
            int header = 0;
            double average = 0;
            int corruptLine = 0;
            

            while (fileScanner.hasNextLine()) {
                lineNumber++;
                //reads the file while it has nextLine
                //also creates the line as a string
                String line = fileScanner.nextLine();
                //counts the number of lines read

                // resets the number counter back to 0
                if (line.isEmpty()) {
                    corruptLine++;

                    System.out.println("*** Error (line " + lineNumber + "): Line is empty - average can't be taken");
                }
                int numberCount = 0;
                int headerCount = 0;
                int sum = 0;
                int valid = 0;

                //creats a scanner object that will read just the string
                //previously ccreated
                Scanner lineScanner = new Scanner(line);

                while (lineScanner.hasNextInt()) {

                    header = lineScanner.nextInt();

                    while (lineScanner.hasNextInt()) {

                        number = lineScanner.nextInt();
                        sum = sum + number;
                        //counts the number of numbers on  the line
                        numberCount++;
                        average = (double) sum / numberCount;
                    }

                    if (header == 0) {
                        corruptLine++;
                       
                        

                        System.out.println("*** Error (line " + lineNumber
                                + "): Header value of 0 - average can't be taken");
                        continue;
                        

                    }
                    if (header < 0) {
                        corruptLine++;

                        System.out.println("*** Error (line " + lineNumber
                                + "): Corrupt line - negative header value");
                        continue;

                    }
                    if (header > numberCount) {
                        corruptLine++;

                        System.out.println("*** Error (line " + lineNumber
                                + "): Corrupt line - fewer values than header");
                        continue;
                    }
                    if (header < numberCount && header > 0) {
                        corruptLine++;

                        System.out.println("*** Error (line " + lineNumber
                                + "): Corrupt line - extra values on line");
                        continue;
                    }

                    System.out.println("The average of the values on line "
                            + lineNumber + " is " + average);

                }

            }
            System.out.println("\nThere were " + (lineNumber - corruptLine) + " valid lines of data");
            System.out.println("There were " + (corruptLine) + " corrupt lines of data");

        } catch (Exception a) {
        }
    }
}
