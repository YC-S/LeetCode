package contest.leetcode.单周赛._262;

import java.util.ArrayList;
import java.util.List;

public class B {
  public int minOperations(int[][] grid, int x) {
    List<Integer> list = new ArrayList<>();
    int m = grid.length;
    int n = grid[0].length;
    int total = 0;
    int count = m * n;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        list.add(grid[i][j]);
        total += grid[i][j];
        min = Math.min(min, grid[i][j]);
        max = Math.max(max, grid[i][j]);
      }
    }
    int average = total / count;
    int left = average - x;
    int right = average + x;
    int res = Integer.MAX_VALUE;
    for (int i = left; i <= right; i++) {
      int cur = 0;
      boolean exist = true;
      for (int num : list) {
        if (Math.abs(num - i) % x != 0) {
          exist = false;
          break;
        } else {
          cur += Math.abs(num - i) / x;
        }
      }
      if (exist) {
        res = Math.min(res, cur);
      }
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }
}
