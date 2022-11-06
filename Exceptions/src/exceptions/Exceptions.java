/*
 * 10/19 Exceptions
 */
package RectangleApp;

import java.util.Scanner;
import java.io.*;

/**
 * an Exception is caused by a RUNTIME ERROR. It happens when the program
 * compiles correctly, but then during runtime, the JVM gets stuck. If your
 * program does not catch an exception, the program terminates, and several red
 * lines of msgs get printed. Some examples of exceptions that we have seen:
 * FileNotFoundException NullPointerException ClassNotFoundExcepton
 * ArrayIndexOutOfBounds InputMismatchException StringIndexOutOfBounds
 * ArithmeticException: / by zero HANDLING AN EXCEPTION : when there is an
 * exception we want the program to work it out, figure out some way that the
 * program can continue running. The catch block is the exception handler
 *
 * 3 parts to Exception handling a program: throw try catch throw is done by the
 * class (or method) that sees the problem try/catch go together and they are
 * done by the code that calls the class (or method) that throws the exception.
 * An Exception is an object of type Exception (or some other kind of exception
 * type)
 *
 * An Exception such as FileNotFoundException has to be either declared -- write
 * throws Exception in header of the method OR caught -- you have a try/catch
 * block next time: quiz continue with Liang example, do InputMismatchException
 * example put code into Rectangle class discss PB again in terms exceptions
 */
public class Exceptions1019 {

    public static void main(String[] args) {
        // What happens if the file "myData.txt" does not exist?
        // program crashes (throws an Exception)
        // Exception in thread "main" java.io.FileNotFoundException: 

        int x = 5, y = 1;
        if (y == 0) {
            System.out.println("DIVIDE BY ZERO!!!!");
            System.exit(1); // terminates the running of the pgm
        }
        int q = x / y;
        File infile = new File("myData2.txt"); // step 1

        /*
        if (!infile.exists()) {
            System.out.println("The input file does not exist.");
            System.exit(1); // terminates the running of the pgm
        }
         */
        try {
            Scanner scanfile = new Scanner(infile); // step2
            while (scanfile.hasNext()) {
                // String line = scanfile.nextLine();
                if (scanfile.hasNextInt()) {
                    int num = scanfile.nextInt();
                }
                String line = scanfile.nextLine();
                System.out.println(line);
            }
            scanfile.close();
        } catch (FileNotFoundException ex) {
            System.out.println("exception FileNotFoundException is caught!");
        }
    }
    // if you try to read wrong type of data, you get:
    // Exception in thread "main" java.util.InputMismatchException
}
