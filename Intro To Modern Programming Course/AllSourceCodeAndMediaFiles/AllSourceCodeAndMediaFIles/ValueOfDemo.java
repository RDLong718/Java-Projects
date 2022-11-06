public class ValueOfDemo { 
  public static void main(String[] args) { 
    Integer x1 = new Integer("32");
    Integer x2 = new Integer("32");
    Integer x3 = Integer.valueOf("32");
    Integer x4 = Integer.valueOf("32");
    Integer x5 = 32;  
    System.out.println("x1 == x2 is " + (x1 == x2)); // Display false
    System.out.println("x1 == x3 is " + (x1 == x3)); // Display false
    System.out.println("x3 == x4 is " + (x3 == x4)); // Display true
    System.out.println("x3 == x5 is " + (x3 == x5)); // Display true
  }
}