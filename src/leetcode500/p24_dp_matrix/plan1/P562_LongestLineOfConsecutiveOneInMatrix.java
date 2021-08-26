package leetcode500.p24_dp_matrix.plan1;

public class P562_LongestLineOfConsecutiveOneInMatrix {
  public int longestLine(int[][] mat) {
    int m = mat.length, n = mat[0].length;
    int ones = 0;
    int[][][] dp = new int[m][n][4];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 1) {
          dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : 1;
          dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : 1;
          dp[i][j][2] = (i > 0 && j > 0) ? dp[i - 1][j - 1][2] + 1 : 1;
          dp[i][j][3] = (i > 0 && j < n - 1) ? dp[i - 1][j + 1][3] + 1 : 1;
          ones =
              Math.max(
                  ones,
                  Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
        }
      }
    }
    return ones;
  }
}
