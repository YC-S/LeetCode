package leetcode500.p01_basic_coding.plan1;

public class P463_IslandPerimeter {
  public int islandPerimeter(int[][] grid) {
    int res = 0;
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) {
          res += 4;
          if (i > 0 && grid[i - 1][j] == 1) res -= 2;
          if (j > 0 && grid[i][j - 1] == 1) res -= 2;
        }
      }
    }
    return res;
  }
}
