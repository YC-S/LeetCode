package leetcode500.p21_union_find.plan1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P305_NumberOfIslandsII {
  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> res = new ArrayList<>();
    int[] arr = new int[n * m];
    Arrays.fill(arr, -1);
    boolean[][] grid = new boolean[m][n];
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int islands = 0;
    for (int[] pos : positions) {
      int r = pos[0];
      int c = pos[1];
      if (grid[r][c]) {
        res.add(islands);
        continue;
      }
      grid[r][c] = true;
      int counter = 1;
      for (int[] dir : dirs) {
        int rr = r + dir[0], cc = c + dir[1];
        if (rr >= 0 && rr < m && cc >= 0 && cc < n) {
          if (grid[rr][cc]) {
            if (!isUnioned(getId(rr, cc, n), getId(r, c, n), arr)) {
              union(getId(rr, cc, n), getId(r, c, n), arr);
              counter--;
            }
          }
        }
      }
      islands += counter;
      res.add(islands);
    }
    return res;
  }

  private int getId(int row, int col, int n) {
    return row * n + col;
  }

  private void union(int x, int y, int[] arr) {
    x = find(x, arr);
    y = find(y, arr);
    if (arr[x] <= arr[y]) {
      arr[x] += arr[y];
      arr[y] = x;
    } else {
      arr[y] += arr[x];
      arr[x] = y;
    }
  }

  private boolean isUnioned(int x, int y, int[] arr) {
    return find(x, arr) == find(y, arr);
  }

  private int find(int x, int[] arr) {
    while (arr[x] >= 0) x = arr[x];
    return x;
  }
}
