/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package name;

import java.io.*;
import java.util.*;

/**
 *
 * @author rdlon
 */
public class Name {

    public Name(String last, String first) {
        this.last = last;
        this.first = first;
    }

    public Name(String first) {
        this("", first);
    }

    public String getFormal() {
        return first + " " + last;
    }

    public String getOfficial() {
        return last + ", " + first;

    }

    public String getInitials() {

        char firstInitial = first.charAt(0);
        char lastInitial = last.charAt(0);
        return firstInitial + "." + lastInitial + ".";

    }

    public boolean equals(Name other) {
        return first.equals(other.first) && last.equals(other.last);
    }

    public String toString() {
        return first + " " + last;
    }

    public static Name read(Scanner scanner) {

        if (!scanner.hasNext()) {
            return null;
        }
        String last = scanner.next();
        String first = scanner.next();

        return new Name(last, first);
    }
    private String first, last;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("names.txt"));
        int count = 0;
        Name previouslyReadName = null;

        Name name = read(scanner);

        while (name != null) {
            System.out.println("name: " + name);
            System.out.println("formal: " + name.getFormal());
            System.out.println("official: " + name.getOfficial());
            System.out.println("initials: " + name.getInitials());
            System.out.println();
            //calling read method
            previouslyReadName = read(scanner);
            count++; //increment the count by 1
            if (previouslyReadName == null) {
                break;
            } else if (previouslyReadName.equals(name)) {
                System.out.println("Duplicate name \"" + previouslyReadName.toString() + "\" discovered");

                previouslyReadName = read(scanner);
                count++;

                name = previouslyReadName;
            } else {
                name = previouslyReadName;
            }
        }

        System.out.println("---");
        System.out.println(count + " names processed.");
    }
}
