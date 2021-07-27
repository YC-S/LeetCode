package contest.codechef.startingcontest;

import java.util.Scanner;

public class HighestDivisor {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int res = 1;
    for (int i = 10; i >= 1; i--) {
      if (n % i == 0) {
        res = i;
        break;
      }
    }
    System.out.println(res);
  }
}
