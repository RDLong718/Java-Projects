import java.util.*;
public class BinarySearchListDemo {
  public static void main(String[] args) {
		List<Integer> list1 =
			Arrays.asList(2, 4, 7, 10, 11, 45, 50, 59, 60, 66);
		System.out.println("(1) Index: " + Collections.binarySearch(list1, 7));
		System.out.println("(2) Index: " + Collections.binarySearch(list1, 9));
		List<String> list2 = Arrays.asList("blue", "green", "red");
		System.out.println("(3) Index: " +
		  Collections.binarySearch(list2, "red"));
		System.out.println("(4) Index: " +
		  Collections.binarySearch(list2, "cyan"));
  }
}
