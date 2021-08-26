package leetcode500.p24_dp_matrix.plan1;

public class P221_MaximalSquare {
  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) return 0;
    int m = matrix.length, n = matrix[0].length, res = 0;
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;
          res = Math.max(dp[i][j], res); // update result
        }
      }
    }
    return res * res;
  }
}
