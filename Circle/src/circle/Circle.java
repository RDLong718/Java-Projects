/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circle;

public class Circle {

    /* Class has state---fields
    AND behavior methdds
     */
    private double radius;

    /* method of the class is behavior of the class
    this method is NOT static which means that it acts on
    an instance of an object
     */
    public double getRadius() {
        return radius;
    }

    public void setRadius(double r) {
        radius = r;

    }

    public static void main(String[] arr) {

        Circle myCircle = new Circle();

        myCircle.setRadius(1.2);
        System.out.println("radius of myCricle is: " + myCircle.getRadius());
        Circle c2 = new Circle();
    }
}
