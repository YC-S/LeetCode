package contest.codechef.july_cookoff;

import java.util.Scanner;

public class ChefAndGCD {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < n; i++) {
      int x = sc.nextInt();
      int y = sc.nextInt();
      if (x > y) {
        int tmp = x;
        x = y;
        y = tmp;
      }
      int count = 0;
      while (true) {
        if (y % x == 0 && x != 1) {
          System.out.println(count);
          break;
        } else {
          y++;
          count++;
        }
      }
    }
  }
}
