package contest.leetcode.单周赛._261;

import java.util.Arrays;

public class B {
  public static int[] missingRolls(int[] rolls, int mean, int n) {
    int total = mean * (rolls.length + n);
    for (int roll : rolls) {
      total -= roll;
    }
    if ((total / n > 6)
        || (total / n == 6 && total % n != 0)
        || (total <= 0)
        || (total / n == 0 && total % n != 0)) {
      return new int[0];
    } else {
      int[] res = new int[n];
      int avg = total / n;
      int i = 0;
      for (; i < n - 1; i++) {
        res[i] = avg;
        total -= avg;
      }
      if (total <= 6) {
        res[i] = total;
        return res;
      } else {
        res[i] = 6;
        total -= 6;
        i--;
        while (total > (6 - avg)) {
          res[i] = 6;
          total -= (6 - avg);
          i--;
        }
      }
      res[i] = total + avg;
      return res;
    }
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(missingRolls(new int[] {3, 2, 4, 3}, 4, 2)));
    System.out.println(Arrays.toString(missingRolls(new int[] {1, 5, 6}, 3, 4)));
    System.out.println(Arrays.toString(missingRolls(new int[] {1, 2, 3, 4}, 6, 4)));
    System.out.println(Arrays.toString(missingRolls(new int[] {6, 3, 4, 3, 5, 3}, 1, 6)));
    System.out.println(
        Arrays.toString(
            missingRolls(
                new int[] {
                  4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4, 5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4,
                  3, 5, 1, 5
                },
                4,
                40)));
  }
}
