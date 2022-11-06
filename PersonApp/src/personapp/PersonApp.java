/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personapp;

/* 10/14/2020
 * This PersonApp shows how to use the Person class which itself uses
 * composition with the Name class.
 * 
 */


/**
 *
 * 
 */
public class PersonApp {
    public static void main(String[] args) {
        /******TOPIC 1 of today: composition ******/
        // how can I instantiate a Person object?
        // invoke first constructor
        Name nm = new Name("Doe", "John");
        Person p = new Person(nm, 1234); // calls first constructor
        System.out.println("Name: " + nm + " Person: " + p);
        // invoke second constructor
        Person p2  = new Person("Alice", "Smith", 9876);
        System.out.println("Person 2: " + p2);
        
        /*******TOPIC 2: array of objects **********/
        final int SIZE = 10;
        // how to create an int array
        int[] arr = new int[SIZE];
        // use the user defined type instead of int
        // an array of REFERENCE VARIABLES gets created 
        // each loc in the array is initialized to null
        Person[] people = new Person[SIZE];
        System.out.println("Here is the people array:");
        for (int i=0; i<people.length; i++)
            System.out.println(people[i]);
        
        // on line 18 I called new to create a Person object
        people[0] = p;
        people[1] = p2; // setting array values to existing Person objects
        people[2] = new Person("Valerie", "Cole", 7654); 
        System.out.println("Here are the first 3 in people array:");
        for (int i=0; i<3; i++)
            System.out.println(people[i]);
        
        // Lets do an example of Rectangle array
        Rectangle[] rectList = new Rectangle[SIZE];
        // this would cause a NullPointerException
        // rectList[0].setWidth(12);
        
        for (int i=0; i<rectList.length; i++) {
            rectList[i] = new Rectangle();
        }
        rectList[0].setWidth(12);
        rectList[0].setLength(4);
        System.out.println("sum of areas of rectList is: " +
                sumAreas(rectList));
        
    }
    /** method sumAreas accepts an array of Rectangle objects
     *  and adds up areas of all objects in the array
     *  @ param rectArray
     *  @return sum of all areas
     */
    public static double sumAreas(Rectangle[] rectArray) {
        // loop through the array and get sum
        double sum=0.0;
        for (int i=0; i<rectArray.length; i++) {
            sum += rectArray[i].getArea();
        }
        return sum;
    }
}

