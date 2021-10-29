package leetcode500.p22_dp.plan8;

import java.util.Arrays;

public class P568_MaximumVactionDays {
  public int maxVacationDays(int[][] flights, int[][] days) {
    // max weight(days) with at most k edges(weeks).  k = days[0].length. n = flights.length
    // bellman ford
    int n = flights.length, k = days[0].length;

    int[][] vacationDays =
        new int[2]
            [n]; // after k weeks, what were the most vacationdays if it is ending at ith city.
    Arrays.fill(vacationDays[0], -1);
    Arrays.fill(vacationDays[1], -1);
    vacationDays[0][0] = vacationDays[1][0] = 0; // start from 0

    for (int i = 0; i < k; i++) {
      int[] previous = vacationDays[1 - i & 1];
      int[] current = vacationDays[i & 1];

      // flying once or stay at the same
      for (int from = 0; from < n; from++) {
        for (int to = 0; to < n; to++) {
          if ((from == to || flights[from][to] != 0) && previous[from] >= 0) {
            // if previous[from] < 0, cannot reach from city, do nothing
            current[to] = Math.max(current[to], previous[from] + days[to][i]);
          }
        }
      }
    }

    int max = 0;
    int[] current = vacationDays[1 - k & 1];
    for (int i = 0; i < n; i++) {
      max = Math.max(current[i], max);
    }

    return max;
  }
}
