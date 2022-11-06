/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

/**
 *
 * @author rdlon
 */
public class Quiz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println(alg(4));
        
        
        
    }
        public static int alg(int n) {

    if (n==1)
       return 1 ;
    return n + alg(n-1);

        // TODO code application logic here
    }
    
}
