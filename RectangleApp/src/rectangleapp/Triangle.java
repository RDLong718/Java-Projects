/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rectangleapp;

/**
 *
 * @author SokolFam
 */
public interface Shape {
   // public abstract -- optional since this is default
    int perimeter();
    double area();
    int numSides();
}

public abstract class Triangle implements Shape {
    protected int side1, side2, side3;
    
    public Triangle(int x, int y, int z) {
        side1=x;
        side2=y;
        side3=z;
    }
    @Override
    public int numSides() {
        return 3;
    }
    @Override
    public int perimeter() {
        return side1+side2+side3;
    }
    // last bullet does not need anything since it is inherited from the interface
}

/* answer to #3 

i      numSides      perimeter       area
0      Triangle      Triangle       EquilateralTriangle
1      Triangle      Triangle       RightTriangle
2      Rectangle     Rectangle      Rectangle

*/

