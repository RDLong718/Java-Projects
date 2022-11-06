/* classes help you create object
 * PDT's let you create variables
 */
package rectangleapp;

/**
 * Wrapper class for PDT's:
 * int Integer
 * double Double
 * float Float
 * char Character
 * boolean Boolean
 * 
 */
import java.util.*;

public class Wrappers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int num=10; // variable
        Integer obj = new Integer(100);
        
        System.out.println("num: " + num +" obj: " + obj);
        obj = num; // allowed, JVM does the work behind the scene to convert
        // the var to object and vice versa -- BOXING 
        System.out.println("num: " + num +" obj: " + obj);
        
        obj=900; // allowed 
        System.out.println("num: " + num +" obj: " + obj);
        obj++; // allowed due to UNBOXING
        System.out.println("num: " + num +" obj: " + obj);
        num = obj; // allowed due to UNBOXING   
        System.out.println("num: " + num +" obj: " + obj);
        
        // need to use wrapper classes in order to create an ArrayList
        // or any Collection 
        ArrayList<Integer> intList = new ArrayList<>();
    }
}
/****
        
        // wrapper classes for primitive data types are immutable
// However, you can still change where the object reference points to
// as we do with Strings that are also immutable

      	Integer i = new Integer(89);
	//  identical to:  Integer i = 89;
        
        
        System.out.println("i="+i);

	i = new Integer(76);
        System.out.println("i="+i);

	i = 90;
        System.out.println("i="+i);
	
	i=i+1;
        System.out.println("i="+i);

        modify(i);
        System.out.println("Returned from method, i="+i);
      }
/
    private static void modify(Rectangle rect) {

        rect.setLength(1.1); // this would modify rect object
	rect = new Rectangle(3,4);
    }
It is always true that modifying the reference variable itself does not change
anything for the calling method. Modifying the object rect refers to will stick.
/
 
    private static void modify(Integer localI)
    {
        localI = localI + 1;
        System.out.println("In method modify, localI="+localI);
    }
    // Unbox i to an int value
    // Add 1 to that value
    // Box the result into another Integer object
    // Assign the resulting Integer to i (thus changing what object i references)
// since i is a reference (pass by value) changing which object it references has no meaning when you return

    }   
}
****/



