package leetcode500.p22_dp.plan7;

import java.util.Arrays;

public class P688_KnightProbabilityInChessboard {
  public double knightProbability(int n, int k, int row, int column) {
    int[][] dirs =
        new int[][] {{1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, 2}, {-2, 1}, {-1, -2}, {-2, -1}};
    double[][] dp = new double[n][n];
    for (double[] r : dp) Arrays.fill(r, 1);
    for (int l = 0; l < k; l++) {
      double[][] dp1 = new double[n][n];
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          for (int[] dir : dirs) {
            int ro = i + dir[0];
            int col = j + dir[1];
            if (isLegal(ro, col, n)) dp1[i][j] += dp[ro][col];
          }
        }
      }
      dp = dp1;
    }
    return dp[row][column] / Math.pow(8, k);
  }

  private boolean isLegal(int r, int c, int len) {
    return r >= 0 && r < len && c >= 0 && c < len;
  }
}
