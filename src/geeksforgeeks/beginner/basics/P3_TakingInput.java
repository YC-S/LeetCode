package geeksforgeeks.beginner.basics;

import java.util.Scanner;

public class P3_TakingInput {
  static void IOFunction() {
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    while (t-- > 0) {
      int a = Integer.parseInt(sc.nextLine());
      float b = Float.parseFloat(sc.nextLine());
      long c = Long.parseLong(sc.nextLine());
      byte d = Byte.parseByte(sc.nextLine());
      String s = sc.nextLine();
      System.out.println(a);
      System.out.println(b);
      System.out.println(c);
      System.out.println(d);
      System.out.println(s);
    }
  }

  public static void main(String[] args) {
    IOFunction();
  }
}
