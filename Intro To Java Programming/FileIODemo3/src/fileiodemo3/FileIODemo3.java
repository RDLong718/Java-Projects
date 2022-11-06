/**
 * @author Yedidyah Langsam
 * @since 09-08-2017
 * @version 1.0 Description: Illustrates basic file IO in Java
 */
package fileiodemo3;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
public class FileIODemo3 {
 public static void main(String[] args) throws Exception {
 int average;
 char grade;
 Scanner scanner = new Scanner(System.in);
 PrintStream ps = new PrintStream("grades.txt");
 System.out.println("Enter the name and the average");
 while (scanner.hasNext()) {
 String name = scanner.next();
 average = scanner.nextInt();
 if (average >= 90) {
 grade = 'A';
 }
 else if (average >= 80) {
 grade = 'B';
 }
 else if (average >= 70) {
 grade = 'C';
 }
 else if (average >= 60) {
 grade = 'D';
 }
 else {
 grade = 'F';
 }
  ps.println(name + ": " + grade + " (" + average + ")");
 }
 }
}
 