/*
 * This file is part of the RectangleApp package.
 * It contains the main method. ONLY one file in a package (ie project) will
 * have a main method.
 * This App uses the Rectangle class which is included in this project.
 * 10/28 Inheritance
 * What can I do with a Rectangle object now that it IS-A SimpleGeometricObject?
Anything that is public in the SimpleGeometricObject class can be called on 
a Rectangle object. A Rectangle IS-A SimpleGeometricObject.
This is a 1 way relationship.
How can I get a filled Rectangle object that is blue?
1. pass these values into the constructor. I need the modify the constructor
in the Rectangle class to accept these values, to set these values.
  How should I modify the constructor in the Rectangle class?
   1a. Call the setters (mutators) of the parents class since they are public
   1b. 
2.

 * */
package rectangleapp;

/**
 *
 * @author 
 */
import java.util.*;

public class RectangleApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Rectangle livingRoom = new Rectangle(1, 4, "blue", true);

            Scanner input = new Scanner(System.in);
            livingRoom = Rectangle.read2(input);
            System.out.println("Living Room has dimensions: " + livingRoom.getLength() + " " 
                    + livingRoom.getWidth());
            if (livingRoom.isFilled())
                System.out.println("object livingRoom is filled.");
            else
                System.out.println("object livingRoom is NOT filled.");
            // you can create a SimpleGeometricObject
            SimpleGeometricObject object = new SimpleGeometricObject("blue", true);
            System.out.println("object is: " + object);
            // object.setLength(8.9); NO!! the parent cannot call child's methods
        }
        catch (InputMismatchException e) {
            System.out.println("There was something wrong with the input");
        }
        catch (Exception e) {
            System.out.println("Exception was caught, " + e.getMessage());
        }
        System.out.println("Continuing program, livingRoom may not be instantiated");    
    }   
}



