/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author rdlon This Program reads in coordinates from a file (points.txt). It
 * uses the points class given to us. It shows various methods of the Points
 * class.
 */
public class PointApp {

    public static void main(String[] args) throws Exception {

        Scanner inputFile = new Scanner(new File("points.txt"));

        Point origin = new Point(0, 0);

        while (inputFile.hasNext()) {

            Point p1 = Point.read(inputFile);
            Point p2 = Point.read(inputFile);

            System.out.println("p1: " + p1 + " (quadrant " + p1.quadrant() + ") / p2: " + p2 + " (quadrant " + p2.quadrant() + ")");

            System.out.println("p1+p2: " + p1.add(p2) + " (quadrant " + p1.add(p2).quadrant() + ")");

            if (p1.xReflection().equals(p2)) {

                System.out.println("p1 and p2 are reflections across the x-axis");
            }
            if (p1.yReflection().equals(p2)) {

                System.out.println("p1 and p2 are reflections across the y-axis");
            }
            if (p1.originReflection().equals(p2)) {

                System.out.println("p1 and p2 are reflections through the origin");
            }
            if (p1.distance(origin) == p2.distance(origin)) {

                System.out.println("p1 and p2 are equidistant from the origin");
            }

            System.out.println("The distance between " + p1 + " and " + p2 + " is " + p1.distance(p2) + "\n");
        }
    }

}
