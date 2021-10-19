package leetcode500.p22_dp.plan5;

public class P410_SplitArrayLargestSum {
  public int splitArray(int[] nums, int m) {
    int n = nums.length;
    int[] dp = new int[n + 1];
    for (int i = n - 1; i >= m - 1; --i) {
      dp[i] = dp[i + 1] + nums[i];
    }
    for (int k = 2; k <= m; ++k) {
      for (int i = m - k; i <= n - k; ++i) {
        dp[i] = Integer.MAX_VALUE;
        for (int j = i, sum = 0; j <= n - k; ++j) {
          sum += nums[j];
          if (sum >= dp[i]) break;
          dp[i] = Math.max(sum, dp[j + 1]);
        }
        if (k == m) break;
      }
    }
    return dp[0];
  }
}
