/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 *
 * Description: Arguments are passed to parameters by a mechanism known as a 
 * Call by Value. The value of the arguments are sent to the parameters, but
 * changing the parameters does not change the corresponding arguments.
 */

package callbyvalue;

public class CallByValue {
    
    public static void main(String[] args) {
        int n = 3, sum;
        
        System.out.printf("n = %d\n", n);
        sum = computeSum(n);
        System.out.printf("sum = %d\n", sum);
    }
    
    // Sum the integers from 1 to 10. 
    public static int computeSum(int n){
         int sum = 0;
         for (; n > 0; n--) {
             sum += n;
         }
         System.out.printf("n = %d\n", n);
         return sum;
     } 
}
