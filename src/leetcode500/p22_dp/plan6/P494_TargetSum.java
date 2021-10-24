package leetcode500.p22_dp.plan6;

public class P494_TargetSum {
  public int findTargetSumWays(int[] nums, int target) {
    int[] dp = new int[2001];
    dp[nums[0] + 1000] = 1;
    dp[-nums[0] + 1000] += 1;
    for (int i = 1; i < nums.length; i++) {
      int[] next = new int[2001];
      for (int sum = -1000; sum <= 1000; sum++) {
        if (dp[sum + 1000] > 0) {
          next[sum + nums[i] + 1000] += dp[sum + 1000];
          next[sum - nums[i] + 1000] += dp[sum + 1000];
        }
      }
      dp = next;
    }
    return target > 1000 ? 0 : dp[target + 1000];
  }
}
