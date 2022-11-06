/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package largestfromtextfile;

import java.util.Scanner;
import java.io.File;

/**
 *
 * @author rdlon
 */
public class LargestFromTextFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String oldestName;

        int age, oldest;
                
        Scanner scanner = new Scanner(new File("data.txt"));
        age = 1;
        oldest = 1;
        oldestName = "john";
        while (scanner.hasNext()) {
            String name = scanner.next();
            
            age = scanner.nextInt();
            if (age > oldest) {
                oldest = age;
                oldestName = name;

            }
            
                       
        }
        
        System.out.printf("this person is the oldest %s",oldestName);
        System.out.printf(" the oldest whose age is %d\n",oldest);
        

    }

}
