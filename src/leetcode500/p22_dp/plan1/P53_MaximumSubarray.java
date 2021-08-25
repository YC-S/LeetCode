package leetcode500.p22_dp.plan1;

public class P53_MaximumSubarray {
  public int maxSubArray(int[] nums) {
    // -2, 1, -3, 4, -1, 2, 1, -5, 4
    if (nums == null || nums.length == 0) return 0;
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int max = dp[0];
    for (int i = 1; i < nums.length; i++) {
      if (dp[i - 1] < 0) {
        dp[i] = nums[i];
      } else {
        dp[i] = nums[i] + dp[i - 1];
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
