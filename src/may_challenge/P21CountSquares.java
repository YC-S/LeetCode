/*
 * Copyright (c) 2020. Yuanchen
 */

package may_challenge;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/05/21
 */
public class P21CountSquares {

  public static int countSquares(int[][] matrix) {
    int n = matrix.length, m = matrix[0].length, res = 0;
    int[][] dp = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j];
        } else if (matrix[i][j] == 0) {
          dp[i][j] = 0;
        } else {
          dp[i][j] =
            Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1])
              + 1;
        }
        res += dp[i][j];
      }
    }
    return res;
  }
}
