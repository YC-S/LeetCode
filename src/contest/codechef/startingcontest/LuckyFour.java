package contest.codechef.startingcontest;

import java.util.Scanner;

public class LuckyFour {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    int[] nums = new int[T];
    for (int i = 0; i < T; i++) {
      nums[i] = scanner.nextInt();
    }
    for (int num : nums) {
      System.out.println(countFour(num));
    }
  }

  private static int countFour(int num) {
    int count = 0;
    while (num != 0) {
      int cur = num % 10;
      if (cur == 4) count++;
      num /= 10;
    }
    return count;
  }
}
