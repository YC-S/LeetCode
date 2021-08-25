package leetcode500.p22_dp.plan1;

public class P343_IntegerBreak {
  public int integerBreak(int n) {
    int[] dp = new int[n + 1];
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i / 2; j++) {
        dp[i] = Math.max(dp[i], Math.max(dp[j], j) * Math.max(dp[i - j], i - j));
      }
    }
    return dp[n];
  }
}
