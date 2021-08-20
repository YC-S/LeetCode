package leetcode500.p00_api;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class C2_ArrayTypes {
  public static void main(String[] args) {
    int[] array = new int[] {1, 2, 3};
    int[][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] m2 = new int[3][];
    m2[0] = new int[] {1, 2, 3};
    m2[1] = new int[] {4, 5, 6, 5, 4};
    m2[2] = new int[] {7, 8, 9};
    for (int[] ints : m2) {
      System.out.println(Arrays.toString(ints));
    }

    // Collections use size() method
    List<Integer> list = Arrays.asList(1, 2, 3);
    System.out.println(list);

    System.out.println(1e10 + 7);

    // String use length() method
    String str = "hello world";
    System.out.println(str.length());

    // Array use length field.
    System.out.println(array.length);

    // review Arrays class static utilities
    array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(Arrays.binarySearch(array, 5));
    Arrays.stream(array).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue);
    System.out.println(Arrays.toString(array));
    Arrays.fill(array, 1);
    System.out.println(Arrays.toString(array));

    int[] b = Arrays.copyOf(array, array.length);
    System.out.println(Arrays.toString(b));

    int[] c = Arrays.copyOfRange(array, 0, 3);
    System.out.println(Arrays.toString(c));
  }
}
