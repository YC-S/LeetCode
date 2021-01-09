/*
 * Copyright (c) 2020. Yuanchen
 */

package explore.month_challenge._2020_june;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/06/03
 */
public class P3TwoCityScheduling {

  public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o1[1] - (o2[0] - o2[1]);
      }
    });

    int total = 0;
    int n = costs.length / 2;
    // To optimize the company expenses,
    // send the first n persons to the city A
    // and the others to the city B
    for (int i = 0; i < n; ++i) {
      total += costs[i][0] + costs[i + n][1];
    }
    return total;
  }
}
