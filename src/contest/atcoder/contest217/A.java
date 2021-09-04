package contest.atcoder.contest217;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] arr = sc.nextLine().split(" ");
    if (arr[0].compareTo(arr[1]) < 0) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }
}
