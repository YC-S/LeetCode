package contest.codechef.practice.beginner;

import java.util.Scanner;

public class ATM {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double x = sc.nextDouble();
    double y = sc.nextDouble();
    double res;
    if (x + 0.5 > y) {
      res = y;
    } else if (x % 5 == 0) {
      res = y - x - 0.5;
    } else {
      res = y;
    }

    System.out.printf("%.2f", res);
  }
}
