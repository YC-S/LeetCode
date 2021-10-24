package leetcode500.p22_dp.plan6;

import java.util.Arrays;

public class P416_PartitionEqualSubsetSum {
  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 == 1) return false;
    sum /= 2;
    boolean[] dp = new boolean[sum + 1];
    Arrays.fill(dp, false);
    dp[0] = true;
    for (int num : nums) {
      for (int j = sum; j >= num; j--) {
        dp[j] |= dp[j - num];
      }
    }
    return dp[sum];
  }
}
