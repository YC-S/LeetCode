package leetcode500.p22_dp.plan2;

import java.util.Arrays;

public class P300_LongestIncreasingSubsequence {
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    Arrays.fill(dp, 1);
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    int res = 0;
    for (int i : dp) {
      res = Math.max(res, i);
    }
    return res;
  }
}
