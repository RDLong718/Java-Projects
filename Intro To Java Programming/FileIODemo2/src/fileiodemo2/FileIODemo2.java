/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 * Description: Illustrates basic file IO in Java
 */
package fileiodemo2;
import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;
public class FileIODemo2 {
 public static void main(String[] args) throws Exception {
 Scanner scanner = new Scanner(new File("roster.txt"));
 PrintStream ps = new PrintStream("grades.txt");
 int total = 0, maxAverage = 0, numStudents = 0;
 while (scanner.hasNext()) {
 String name = scanner.next();
 int average = scanner.nextInt();
 char grade = averageToGrade(average);
 ps.println(name + ": " + grade + " (" + average + ")");
 if (average > maxAverage) {
 maxAverage = average;
 }
 total += average;
 numStudents++;
 }
 ps.println();
 ps.println("Class average: " + (total / numStudents));
 ps.println("Highest individual average: " + maxAverage);
 }
 // The averageToGrade method recieves average grade (as an int) and
 // returns the corrosponding letter grade (char).
 public static char averageToGrade(int average) {
   if (average >= 90) {
 return 'A';
 }
 if (average >= 80) {
 return 'B';
 }
 if (average >= 70) {
 return 'C';
 }
 if (average >= 60) {
 return 'D';
 }
 return 'F';
 }
}   
 }