package leetcode500.p22_dp.plan8;

public class P651_4KeysKeyboard {
  public int maxA(int n) {
    int[] dp = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      dp[i] = i;
      for (int j = 1; j <= i - 3; j++) dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
    }
    return dp[n];
  }
}
