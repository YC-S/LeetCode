package leetcode500.p22_dp.plan7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P656_CoinPath {
  public List<Integer> cheapestJump(int[] coins, int maxJump) {
    List<Integer> res = new ArrayList<>();
    int n = coins.length;
    int[] cost = new int[n];
    int[] previous = new int[n];
    int[] length = new int[n];
    Arrays.fill(cost, Integer.MAX_VALUE);
    Arrays.fill(previous, -1);
    cost[0] = 0;
    for (int i = 0; i < n; i++) {
      if (coins[i] == -1) continue;
      for (int j = Math.max(0, i - maxJump); j < i; j++) {
        if (coins[j] == -1) continue;
        int alt = cost[j] + coins[i];
        if (alt < cost[i] || alt == cost[i] && length[i] < length[j] + 1) {
          cost[i] = alt;
          previous[i] = j;
          length[i] = length[j] + 1;
        }
      }
    }
    for (int cur = n - 1; cur >= 0; cur = previous[cur]) res.add(0, cur + 1);
    return res.get(0) == 1 ? res : new ArrayList<>();
  }
}
