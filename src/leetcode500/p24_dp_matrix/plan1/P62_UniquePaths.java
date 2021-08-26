package leetcode500.p24_dp_matrix.plan1;

public class P62_UniquePaths {
  public static int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0) dp[i][j] = 1;
        else if (j == 0) dp[i][j] = 1;
        else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    return dp[m - 1][n - 1];
  }

  public static void main(String[] args) {
    System.out.println(uniquePaths(3, 2));
  }
}
