/**
 * @author Yedidyah Langsam
 * @since 11-06-2016
 * @version 1.0
 * 
 * Description: Calculates A raised to the B power, for non-negative values of B.
 */
package apowerb;

public class APowerB {

    //The main method illustrates how to use the APowerB method
    public static void main(String[] args) {

        double a, b, c, d, result;

        a = 3;
        b = 5;
        c = 2;
        d = 5;
        result = aPowerB(a, b) + aPowerB(c, d);

        System.out.printf("\nAPowerB(%.0f,%.0f) + APowerB(%.0f,%.0f) = %.0f\n",
                a, b, c, d, result);
    }
    
    // Method calculates A raised to the B power for non-negative values of B.
    public static double aPowerB(double a, double b) {
        double i, product;
        
        product = 1;
        for (i = 1; i <= b; i++){
            product *= a;
        }
        return product;
    }
    
    
}
