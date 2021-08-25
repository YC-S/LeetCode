package leetcode500.p22_dp.plan1;

public class P485_MaxConsecutiveOnes {
  public static void main(String[] args) {
    System.out.println(
        new P485_MaxConsecutiveOnes().findMaxConsecutiveOnes(new int[] {1, 1, 0, 1, 1, 1}));
  }

  public int findMaxConsecutiveOnes(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = nums[0];
    int max = nums[0]; // if nums[0] == 1, dp[0] = 1, else dp[0] = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == 1) {
        if (dp[i - 1] >= 1) {
          dp[i] = dp[i - 1] + 1;
        } else dp[i] = 1;
      } else {
        dp[i] = 0;
      }
      max = Math.max(max, dp[i]);
    }
    return max;
  }
}
