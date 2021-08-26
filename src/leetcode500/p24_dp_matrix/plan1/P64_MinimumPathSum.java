package leetcode500.p24_dp_matrix.plan1;

public class P64_MinimumPathSum {
  public int minPathSum(int[][] grid) {
    int m = grid.length; // row
    int n = grid[0].length; // column
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          continue;
        } else if (i == 0) {
          grid[i][j] = grid[i][j] + grid[i][j - 1];
        } else if (j == 0) {
          grid[i][j] = grid[i][j] + grid[i - 1][j];
        } else {
          grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
        }
      }
    }

    return grid[m - 1][n - 1];
  }
}
