package contest.facebook_hacker_cup.year2011.qualification_round;

import java.util.Scanner;

public class A_DoubleSquare {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

    for (int i = 0; i < n; i++) {
      int count = 0;
      int x = scanner.nextInt();
      for (int j = 1; j <= x; j++) {
        double root = Math.sqrt(x - j * j);
        if (root == (int) root) {
          count++;
        }
      }
      System.out.println(count / 2);
    }
  }
}
