package rectangleapp;

import java.util.*;

public class AL   {
/** TestAL is written for the purpose of trying ArrayLists and Generics. 
 ***/

   public static void main(String[] args) {
	
	// this is called using raw types
	// it is not recommended
        // reason: you won't be able to use the elements as their datatype
        // furthermore: THERE WILL BE NOT TYPE CHECKING BY COMPILER
	ArrayList names0 = new ArrayList();
        names0.add(3.5);
	//this is the same thing: 
        ArrayList<Object> names1 = new ArrayList();

        ArrayList<String> names2 = new ArrayList<String>();

	/* Compare and Contrast arrays and ArrayList:
	1. arrays you must specify size and they dont grow or shrink
	   ArrayList you can keep adding locations
	
	2. arrays can be used for PDT's and Objects
	   ArrayList (as all Collections) can be used with only Objects.
	
	3. arrays work with [ ] 
	   ArrayList use method calls such as .get or .add or .set or .contains
	*/

	// to compare with a regular array
	int[] arr = new int[100]; // must specify size 

	ArrayList<Integer> numbers = new ArrayList<>();
	numbers.add(5); // will this work? Yes due to autoboxing

        // you can also specify the size 
	ArrayList<String> names = new ArrayList<>(100);

	System.out.println("size of ArrayList names is: " + names.size());

	names.add("Sara");
	names.add("Molly");
	names.add("Jill");
	names.add("Andre");
	//names.add(3.1);
        System.out.println("indexOf(3) returns " + names.indexOf(3));

//	for (Object name : names)
// use the enhanced for loop on all Collections and it only iterates through the
// actual elements
	for (String name : names)
	    System.out.println(name);

// these 2 methods get, set implement []
	// String aName = names.get(4); // ERROR IndexOutOfBoundsException
	String aName = names.get(0); 
	names.set(2, "Alice");
	names.remove("Andre");
	System.out.println("after putting Alice in loc 2 and removing Andre" + names);
	
        if (names.contains("Molly"))
	    System.out.println("Molly is still in there.");
	else
	    System.out.println("Molly has been removed.");



	ArrayList<Rectangle> rectList = new ArrayList<>();
        try {
            rectList.add(new Rectangle(2,3));
            rectList.add(new Rectangle());
            rectList.add(new Rectangle(4, 5));
        
            //How does my ArrayList class know how to print Rectangles???
            System.out.println("rectList:\n" + rectList);
        }
        catch(Exception e) {
            System.out.println("issues with instantiating Rectangles for ArrayList.");
        }
   }
}
