
package fibonacciaddingsquares;

/**
 *
 * @author Rashad Long
 * This program is to find the sum of squares of Fibonacci numbers
 */

   
public class FibonacciAddingSquares {
     
     // Function to calculate sum of
    // squares of Fibonacci numbers
    static int calculateSquareSum(int n)
    {
        if (n <= 0)
            return 0;
       
        int fibo[] = new int[n+1];
        fibo[0] = 0 ;
        fibo[1] = 1 ;
       
        // Initialize result
        int sum = (fibo[0] * fibo[0]) + (fibo[1] * fibo[1]);
       
        // Add remaining terms
        for (int i = 2; i <= n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
            sum += (fibo[i] * fibo[i]);
        }
       
        return sum;
    }
       
    // Driver code
    public static void main(String args[])
    {
           int number = 5;
           System.out.println("Sum of squares of " + number + " Fibonacci numbers is : " +
                                calculateSquareSum(number));           
    }
    
}
