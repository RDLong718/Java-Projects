/*
 * 9/14/2020
 * 
 */
package phonebookbeta;

import java.util.*;
import java.io.*;
/**
 *
 * @author Sokol
 * This is version 0 of the Phonebook app
 * reviewed the following concepts:
 * 1. partially filled arrays (keeping track of size and capacity)
 * 2. comparing Strings with .equals and not ==
 * 3. keeping track of different Scanner objects, making sure to close them
 * and passing them as parameters
 * 4. linear search on arrays of Strings
 * 5. using a structured read loop (while loop with prompt outside)
 */
public class PhonebookBeta{

  public static void main(String[] args) throws IOException {
   
/*  Given a list of contacts in a file (last name phone number), read them
 * in and let the user search for a contact's phone number.
 */
 
// declare the parallel arrays to store the data
    final int CAPACITY = 100;
    String[] names = new String[CAPACITY];
    String[] numbers = new String[CAPACITY];
    final String filename = "phonebook.txt";
// call a method to fill in these arrays
    int numElts = read(filename, names, numbers);
  
    Scanner keyboard = new Scanner(System.in);
    // structured read loop
    System.out.print("name? ");
    while (keyboard.hasNext()) {
        String name = keyboard.next();
        String number = lookup(names, numbers, name, numElts);
        if (number.equals("")) 
            System.out.println("Not found");
        else
            System.out.println(number);
        System.out.print("name? ");
    }
    keyboard.close();
  }
  
/** lookup method allows user to look up a contact based on last name
 *  performs a classic linear search
 *  @param names -- first array of type String 
 *  @param numbers -- second array of type String
 *  @param lastName String which is the name to look up
 *  @return String which is the phone number 
 */
public static String lookup(String[] names, String[] numbers, String lastName, int size) {
    
    for (int i=0; i<size; i++) {
        if (names[i].equalsIgnoreCase(lastName)) // DO NOT USE == on Strings
            return numbers[i]; // return corresponding phone number
    }
    return ""; // If not found, method will return the empty String
}
/** method read will read in data from a file into two parallel arrays.
 *  @param filename -- name of the file for input
 *  @param names -- first array of type String 
 *  @param numbers -- second array of type String
 *  @return number of elements filled in the array
 */
  public static int read(String filename, String[] names, String[] numbers) 
          throws IOException {
      //File file = new File(filename);
      //Scanner inputFile = new Scanner(file);
      Scanner inputFile = new Scanner(new File(filename));
      // size is used as an index into the array, and it keeps track of the 
      // first empty loc in the array, which is in effect the number of elts in arr
      int size=0;
      // read in values but MAKE SURE not to exceed capacity of arrays
      while (inputFile.hasNext()) {
          if (size == names.length) {
              System.out.println("Phonebook capacity exceeded - increase size " +
                      "of underlying array");
              System.exit(1); // terminate running of pgm and signal error
          }
          // read in data
          names[size]=inputFile.next();
          numbers[size]=inputFile.next();
          size++;
      }
      inputFile.close();
      return size;
  }
  
}
  
