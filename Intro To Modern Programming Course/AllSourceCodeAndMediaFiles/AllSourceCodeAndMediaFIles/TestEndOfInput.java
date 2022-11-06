import java.util.Scanner;

public class TestEndOfInput {
  public static void main(String[] args) {
    // Create a Scanner
    Scanner input = new Scanner(System.in);
    int sum = 0;
      
    while (input.hasNext()) {
      sum += input.nextInt();
    }
     
    System.out.println("The sum is " + sum);
  }
}
