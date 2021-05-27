package all_problems;

import java.util.Arrays;

public class P1798_MaximumNumberOfConsecutiveValuesYouCanMake {
  public int getMaximumConsecutive(int[] coins) {
    Arrays.sort(coins);
    int res = 1;
    for (int coin : coins) {
      if (coin > res) break;
      res += coin;
    }
    return res;
  }
}
