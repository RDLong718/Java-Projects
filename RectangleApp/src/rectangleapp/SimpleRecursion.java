/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangleapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class SimpleRecursion {

    public static void main(String[] args) {
        message(3);
        System.out.println("factorial of 5 = " + factorial(5));
    }

    /**
     * recursive method calls itself
     */
    public static void message(int n) {

        // BASE CASE
        if (n == 0) {
            return;
        }
        // key point about recursion is that I have to pass something smaller
        // than n into the recursive call
        message(n - 1); // pushes a new frame onto the stack
        System.out.println("Hello, we have " + n + " classes left to this semester.");
        
    }

    public static long factorial(int n) {
        // BASE CASE
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
