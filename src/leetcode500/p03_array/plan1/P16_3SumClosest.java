package leetcode500.p03_array.plan1;

import java.util.Arrays;

public class P16_3SumClosest {
  public int threeSumClosest(int[] nums, int target) {
    int diff = Integer.MAX_VALUE;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      int left = i + 1, right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (Math.abs(sum - target) < Math.abs(diff)) {
          diff = sum - target;
        }
        if (sum < target) {
          left++;
        } else {
          right--;
        }
      }
    }
    return target + diff;
  }
}
