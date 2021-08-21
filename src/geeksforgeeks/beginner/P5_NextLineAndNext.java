package geeksforgeeks.beginner;

import java.util.Scanner;

public class P5_NextLineAndNext {
  static void getInput() {

    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine()); // Taking the number of testcases
    while (t-- > 0) {
      int a = Integer.parseInt(sc.nextLine());
      String s = sc.nextLine();

      // Your code here

      System.out.println(a);
      System.out.println(s);
    }
  }
}
