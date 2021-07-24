package contest.atcoder.contest211;

import java.util.Scanner;

public class A {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    double c = ((double) (a - b) / 3) + b;
    System.out.println(c);
  }
}
