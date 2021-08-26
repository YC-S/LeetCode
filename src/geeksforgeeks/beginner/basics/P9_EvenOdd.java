package geeksforgeeks.beginner.basics;

public class P9_EvenOdd {
  static void evenOdd(int a, int b) {
    if ((a & 1) == 0) {
      System.out.println(a);
      System.out.println(b);
    } else {
      System.out.println(b);
      System.out.println(a);
    }
  }
}
