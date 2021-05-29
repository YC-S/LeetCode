package all_problems;

import java.util.Arrays;

public class P1877_MinimizeMaximumPairSumInArray {
  public int minPairSum(int[] nums) {
    Arrays.sort(nums);
    int res = 0, n = nums.length;
    for (int i = 0; i < n / 2; ++i) res = Math.max(res, nums[i] + nums[n - i - 1]);
    return res;
  }
}
