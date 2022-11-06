/*
 * This file has the Rectangle class. It does NOT have a main.
 * It basically gives the user a new type.
 * 10/28
 * adding INHERITANCE
use the keyword "extends" and you get everything (all fields and all methods)
from the parent class

plan for next time: toString and printing fields that you inherited
constructor chaining
overriding methods
 */
package rectangleapp;
import java.util.Scanner;
/**
 * class has state (data) and behavior (methods)
 * 
 */
public class Rectangle extends SimpleGeometricObject {
    private double width;
    private double length;
  /**
    
    */
    public Rectangle(double wid, double len, String color, boolean filled) throws Exception {
        // Method 1b: INVOKE PARENT'S CONSTRUCTOR for this object
        super(color, filled);
        // don't need the setFilled and setColor anymore since they get set
        // in SimpleGeometricObject constructor
        
        if (wid < 0 || len < 0) {
            throw new Exception("negative dimension not allowed.");
        }
        width = wid;
        length = len;
        // a child class does NOT have access to the private members
        // of its parent
        // this.color = color; cannot do this
        // this.filled = filled; NO 
        // Method 1a for setting inherited fields
        setFilled(filled); // pass parameters to public mutators of SimpleGeometricObject
        setColor(color);
    }
    public Rectangle(double wid, double len) {
        // The compiler puts in a call to super() with NO-ARGS
        // if you don't put any call in.
        super(); // make it white and not filled
        length = len;
        width = wid;
    }
    /** here is a no-arg constructor
     *  Rectangle sets both length and width to zero
     *  use constructor overloading
     */
    public Rectangle() throws Exception {
        //width = length = 0.0;
        // best practice for a constructor to invoke another constructor
        this(0.0, 0.0, "white", false);
    }
     /** this constructor accepts an object of type Rectangle and copies it
      *  into the calling object (receiver object, the "this" object) 
      *  Note that it is allowed to use Rectangle type inside definition
      *  of the Rectangle class
      */
    public Rectangle(Rectangle r) throws Exception {
        this(r.width, r.length);
    }
    // write public methods to allow user access to fields, called ACCESSORS
    // also called getters
    /** getLength 
     * 
     * @return returns length of Rectangle object
     */
    public double getLength()   {
        return length;
    }
    /**getWidth
     * 
     * @return returns width of Rectangle object
     */
    public double getWidth()    {
        return width;
    }
    // to allow the user to change fields, you write MUTATORS
    /** setLength 
     * 
     * @param length 
     */
    public void setLength(double length) throws Exception   {
        // how do I say: the receiver object's length should equal
        // the parameter length
        if (length < 0) throw new Exception();
        this.length = length; // set the value of the instance variable length to parameter len
    }
    /** setWidth
     * 
     * @param width 
     */
    public void setWidth(double width) throws Exception  {
        if (width < 0) throw new Exception();
        this.width = width; // set the receiver object's width to param
    }
    /** getArea
     * @return area of the Rectangle as length*width
     * this method calculates the area to make sure it is up-to-date
     */
    public double getArea() {
        return length*width;
    }
    
    // add method that would return a Rectangle where the length is the
    // addition of both lengths, and the width is the addition of both widths
    public Rectangle add(Rectangle rec) throws Exception {
        Rectangle temp = new Rectangle(this.width + rec.width, this.length + rec.length);
        return temp;
    }
    /** method read that is an INSTANCE method (option 1 in notes)
     *  @param scanner -- accepts Scanner object
     *  returns void
     *  Method reads values into the this object (receiver)
     */
    public void read(Scanner scanner) {
        System.out.println("Enter a length and width: ");
        if (scanner.hasNextDouble()) {
            this.width = scanner.nextDouble();
            this.length = scanner.nextDouble();
        }
    }
    /** Option 3 in notes: a static method in the Rectangle class
     * 
     * @param scanner
     * @return Rectangle object that was created and read in by this method 
     * This is the method used in Lab 3 
     */
    public static Rectangle read2(Scanner scanner) throws Exception {
        System.out.println("Enter a width and length: ");
        // there is NO 'this' object, therefore we create a Rectangle to return 
        Rectangle rect = new Rectangle();
        if (scanner.hasNextDouble()) {
            rect.width = scanner.nextDouble(); // inside the class allowed to access
            rect.length = scanner.nextDouble(); // private fields
          //  rect.filled=false;
        }
        // these few stmts can be done in one stmt as follows:
        // Rectangle rect = new Rectangle(scanner.nextDouble(), scanner.nextDouble());
        return rect;
    }
    /*OVERLOADED METHOD -- same name but different signature */
    public void sayHello() {
        System.out.println("Hello Rectangle");
    }
    /* Exact same signature as my parent's method 
       Closer one OVERRIDES the parent's method.
     */
    @Override
    public double perimeter() {
        return 2*width + 2*length;
    }
    @Override
    public boolean equalsâ€‹(Object obj) {
        if (!(obj instanceof Rectangle))
            return false;
        /* alternate way of checking actual type
        if (this.getClass() != obj.getClass())
            return false;
        */
        Rectangle rect = (Rectangle)obj;
        return length==rect.length && width==rect.width
                && super.equals(rect);
    }
    // great example of polymorphism -- call to parent's equals method
    // parent is expect SimpleGeometricObject, and I am sending a Rectangle
    // which is a SimpleGeometricObject
    public boolean equalsâ€‹(Rectangle obj) {
        return length==obj.length && width==obj.width 
                // check whether inherited fields (filled, color)
                // are same. You can do this by calling equals method of parent
                // which only deals with fields of parent, and it is allowed
                // bec obj IS A SimpleGeometricObject (ie polymorphism)
                && super.equals(obj);
        // this.getFilled()==obj.getFilled() -- this is ok
    }
    
    @Override
    public String toString() {
        // this is one way to do it -- call public methods of parent
        //  return "length: " + length + " width: " + width + " date: " + getDateCreated() 
          //      + " fill color: " + getColor() + " isFilled: " + isFilled();
        // BETTER WAY: invoke toString method of parent
        // OOP: let my parent convert itself to a String
        return "length: " + length + " width: " + width + " "  + super.toString();
    }
}
