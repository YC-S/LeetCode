package leetcode500.p22_dp.plan2;

public class P674_LongestContinousIncreasingSubsequence {
  public int findLengthOfLCIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int left = 0;
    int right = 1;
    int max = 1;
    int cur = 1;
    while (right < nums.length) {
      if (nums[right] > nums[right - 1]) {
        cur++;
        max = Math.max(cur, max);
        right++;
      } else {
        left = right;
        right++;
        cur = 1;
      }
    }
    return max;
  }
}
