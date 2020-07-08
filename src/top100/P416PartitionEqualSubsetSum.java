/*
 * Copyright (c) 2020. Yuanchen
 */

package top100;

/**
 * @author shiyuanchen
 * @project LeetCode
 * @since 2020/07/08
 */
public class P416PartitionEqualSubsetSum {

  public boolean canPartition(int[] nums) {
    int len = nums.length;
    int sum = 0;
    for (int num : nums) {
      sum += num;
    }
    if (sum % 2 == 1) {
      return false;
    }
    sum /= 2;
    boolean[] dp = new boolean[20000];
    for (int i = 0; i <= sum; i++) {
      dp[i] = false;
    }
    dp[0] = true;
    for (int num : nums) {
      for (int j = sum; j >= num; j--) {
        dp[j] |= dp[j - num];
      }
    }
    return dp[sum];
  }
}
